/*
 * @Explorer.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */

package org.fundacionjala.convertor.view.explorer;

import org.fundacionjala.convertor.utils.Style;
import org.fundacionjala.convertor.view.finder.BasicSearchPanel;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

/**
 * Class in process.
 */
public class Explorer extends JPanel {
    private JTree mTree;
    private DefaultTreeModel mModel;
    private Style style;

    /**
     * Constructor of the explorer.
     */
    public Explorer() {
        style = new Style();
        final int width = 200;
        final int height = 300;
        final Color orangeColor = new java.awt.Color(255, 51, 0);

        setSize(width, height);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                new IconData("Computer"));
        DefaultMutableTreeNode node;

        File[] roots = File.listRoots();
        for (File root : roots) {
            node = new DefaultMutableTreeNode(new IconData(new FileNode(root)));
            top.add(node);
            node.add(new DefaultMutableTreeNode(Boolean.TRUE));
        }

        mModel = new DefaultTreeModel(top);
        mTree = new JTree(mModel);
        mTree.setFont(style.getFont());
        mTree.putClientProperty("JTree.lineStyle", "Angled");
        mTree.setCellRenderer(new DefaultTreeCellRenderer());
        mTree.addTreeExpansionListener(new
                DirExpansionListener());
        mTree.addTreeSelectionListener(new
                DirSelectionListener());
        mTree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        mTree.setShowsRootHandles(true);
        mTree.setEditable(false);

        DefaultTreeCellRenderer iconos = (DefaultTreeCellRenderer) mTree.getCellRenderer();
        iconos.setLeafIcon(new ImageIcon("Image\\folder.PNG"));
        iconos.setOpenIcon(new ImageIcon("Image\\pc.PNG"));
        iconos.setClosedIcon(new ImageIcon("Image\\folder.PNG"));

        final int explorerWidth = 200;
        final int explorerHeight = 280;

        JScrollPane s = new JScrollPane(mTree);
        s.setPreferredSize(new Dimension(explorerWidth, explorerHeight));
        s.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createLineBorder(orangeColor)));
        add(s, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * This method its the getter of the default mutable tree node.
     *
     * @param path input Path
     * @return the Default Mutable Tree Node
     */
    private DefaultMutableTreeNode getTreeNode(final TreePath path) {
        return (DefaultMutableTreeNode) (path.getLastPathComponent());
    }

    /**
     * This is the method for get the file node.
     *
     * @param node Input node.
     * @return the File node.
     */
    private FileNode getFileNode(final DefaultMutableTreeNode node) {
        if (node == null) {
            return null;
        }
        Object obj = node.getUserObject();
        if (obj instanceof IconData) {
            obj = ((IconData) obj).getObject();
        }
        if (obj instanceof FileNode) {
            return (FileNode) obj;
        } else {
            return null;
        }
    }

    // Make sure expansion is threaded and updating the tree model
    // only occurs within the event dispatching thread.

    /**
     * Inner class of the Direction expansion listener.
     */
    class DirExpansionListener implements TreeExpansionListener {
        /**
         * Method for expand de tree.
         *
         * @param event input.
         */
        public void treeExpanded(final TreeExpansionEvent event) {
            final DefaultMutableTreeNode node = getTreeNode(
                    event.getPath());
            final FileNode fnode = getFileNode(node);

            Thread runner = new Thread(() -> {
                if (fnode != null && fnode.expand(node)) {
                    Runnable runnable = () -> mModel.reload(node);
                    SwingUtilities.invokeLater(runnable);
                }
            });
            runner.start();
        }

        /**
         * Method for collapse the tree.
         *
         * @param event input
         */
        public void treeCollapsed(final TreeExpansionEvent event) {
        }
    }

    /**
     * Class for select the direction using Listener.
     */
    class DirSelectionListener implements TreeSelectionListener {
        /**
         * This method change the value of the JLabel showing the path.
         *
         * @param event input
         */
        public void valueChanged(final TreeSelectionEvent event) {
            DefaultMutableTreeNode node = getTreeNode(event.getPath());
            FileNode fnode = getFileNode(node);
            if (fnode != null) {
                BasicSearchPanel.getPath().setText(fnode.getFile().getAbsolutePath());
            } else {
                BasicSearchPanel.getPath().setText("");
            }
        }
    }
}


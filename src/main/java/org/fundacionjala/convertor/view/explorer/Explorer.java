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

import org.fundacionjala.convertor.view.finder.BasicSearchPanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;

/**
 * Class in process.
 */
public class Explorer extends JPanel {
    private static final ImageIcon ICON_COMPUTER =
            new ImageIcon("computer.gif");
    private static final ImageIcon ICON_DISK =
            new ImageIcon("disk.gif");
    static final ImageIcon ICON_FOLDER =
            new ImageIcon("folder.gif");
    static final ImageIcon ICON_EXPANDEDFOLDER =
            new ImageIcon("expandedfolder.gif");

    private JTree mTree;
    private DefaultTreeModel mModel;
    private JTextField mDisplay;

    /**
     * Constructor of the explorer.
     */
    public Explorer() {
        final int width = 400;
        final int height = 300;

        setSize(width, height);

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                new IconData(ICON_COMPUTER, null, "Computer"));

        DefaultMutableTreeNode node;
        File[] roots = File.listRoots();
        for (File root : roots) {
            node = new DefaultMutableTreeNode(new IconData(ICON_DISK,
                    null, new FileNode(root)));
            top.add(node);
            node.add(new DefaultMutableTreeNode(Boolean.TRUE));
        }

        mModel = new DefaultTreeModel(top);
        mTree = new JTree(mModel);

        mTree.putClientProperty("JTree.lineStyle", "Angled");

        TreeCellRenderer renderer = new
                IconCellRenderer();
        mTree.setCellRenderer(renderer);

        mTree.addTreeExpansionListener(new
                DirExpansionListener());

        mTree.addTreeSelectionListener(new
                DirSelectionListener());

        mTree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        mTree.setShowsRootHandles(true);
        mTree.setEditable(false);

        JScrollPane s = new JScrollPane();
        s.getViewport().add(mTree);
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

    /**
     * Class for the icon renderer.
     */
    class IconCellRenderer extends JLabel implements TreeCellRenderer {
        private Color mTextSelectionColor;
        private Color mTextNonSelectionColor;
        private Color mBkSelectionColor;
        private Color mBkNonSelectionColor;
        private Color mBorderSelectionColor;

        private boolean mSelected;

        /**
         * Constructor of the Icon cell renderer.
         */
        IconCellRenderer() {
            super();
            mTextSelectionColor = UIManager.getColor(
                    "Tree.selectionForeground");
            mTextNonSelectionColor = UIManager.getColor(
                    "Tree.textForeground");
            mBkSelectionColor = UIManager.getColor(
                    "Tree.selectionBackground");
            mBkNonSelectionColor = UIManager.getColor(
                    "Tree.textBackground");
            mBorderSelectionColor = UIManager.getColor(
                    "Tree.selectionBorderColor");
            setOpaque(false);
        }

        /**
         * Method for paint component.
         *
         * @param g input graphic
         */
        public void paintComponent(final Graphics g) {
            Color bColor = getBackground();
            Icon icon = getIcon();

            g.setColor(bColor);
            int offset = 0;
            if (icon != null && getText() != null) {
                offset = (icon.getIconWidth() + getIconTextGap());
            }
            g.fillRect(offset, 0, getWidth() - 1 - offset,
                    getHeight() - 1);

            if (mSelected) {
                g.setColor(mBorderSelectionColor);
                g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
            }
            super.paintComponent(g);
        }

        /**
         * Method for get the tree cell.
         *
         * @param tree     input tree
         * @param value    input value
         * @param sel      input sel
         * @param expanded input for expand
         * @param leaf     input for leaf
         * @param row      input of the rows
         * @param hasFocus input for focus
         * @return the Component.
         */
        public Component getTreeCellRendererComponent(final JTree tree, final Object value,
                                                      final boolean sel, final boolean expanded,
                                                      final boolean leaf, final int row, final boolean hasFocus) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) value;
            Object obj = node.getUserObject();
            setText(obj.toString());

            if (obj instanceof Boolean) {
                setText("Retrieving data...");
            }

            if (obj instanceof IconData) {
                IconData idata = (IconData) obj;
                if (expanded) {
                    setIcon(idata.getExpandedIcon());
                } else {
                    setIcon(idata.getIcon());
                }
            } else {
                setIcon(null);
            }
            setFont(tree.getFont());
            setForeground(sel ? mTextSelectionColor : mTextNonSelectionColor);
            setBackground(sel ? mBkSelectionColor : mBkNonSelectionColor);
            mSelected = sel;
            return this;
        }
    }
}


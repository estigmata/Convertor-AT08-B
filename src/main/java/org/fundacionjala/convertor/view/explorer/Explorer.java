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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.BorderLayout;
import java.io.File;

/**
 * Class Explorer.
 *
 * @version 1.0.
 */
public class Explorer
        extends JPanel {
    public static final ImageIcon ICON_COMPUTER =
            new ImageIcon("computer.gif");
    public static final ImageIcon ICON_DISK =
            new ImageIcon("disk.gif");
    public static final ImageIcon ICON_FOLDER =
            new ImageIcon("folder.gif");
    public static final ImageIcon ICON_EXPANDEDFOLDER =
            new ImageIcon("expandedfolder.gif");

    protected JTree mTree;
    protected DefaultTreeModel mModel;
    protected StringBuilder pathDir;

    /**
     * Constructor.
     */
    public Explorer() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                new IconData(ICON_COMPUTER, null, "Computer"));

        DefaultMutableTreeNode node;
        File[] roots = File.listRoots();
        for (int k = 0; k < roots.length; k++) {
            node = new DefaultMutableTreeNode(new IconData(ICON_DISK,
                    null, new FileNode(roots[k])));
            top.add(node);
            node.add(new DefaultMutableTreeNode(new Boolean(true)));
        }
        mModel = new DefaultTreeModel(top);
        mTree = new JTree(mModel);
        mTree.putClientProperty("JTree.lineStyle", "Angled");
        mTree.addTreeExpansionListener(new DirExpansionListener());
        mTree.addTreeSelectionListener(new DirSelectionListener());
        mTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        mTree.setShowsRootHandles(true);
        mTree.setEditable(false);
        JScrollPane s = new JScrollPane();
        s.getViewport().add(mTree);
        add(s, BorderLayout.CENTER);
    }

    /**
     * Method to get Tree Node.
     *
     * @param path input a TreePath object.
     * @return the object DefaultMutableTreeNode.
     */

    DefaultMutableTreeNode getTreeNode(final TreePath path) {
        return (DefaultMutableTreeNode) (path.getLastPathComponent());
    }

    /**
     * Method to get File Node.
     *
     * @param node DefaultMutableTreeNode object.
     * @return FileNode object.
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

    /**
     * Class DirExpansionListener.
     * <p>
     * Make sure expansion is threaded and updating the tree model only occurs within the event dispatching thread.
     */
    class DirExpansionListener implements TreeExpansionListener {

        /**
         * Method to tree expanded.
         *
         * @param event event.
         */
        public void treeExpanded(final TreeExpansionEvent event) {
            final DefaultMutableTreeNode node = getTreeNode(
                    event.getPath());
            final FileNode fnode = getFileNode(node);
            Thread runner = new Thread() {

                public void run() {
                    if (fnode != null && fnode.expand(node)) {
                        Runnable runnable = new Runnable() {
                            public void run() {
                                mModel.reload(node);
                            }
                        };
                        SwingUtilities.invokeLater(runnable);
                    }
                }
            };
            runner.start();
        }

        /**
         * Method to tree collapsed.
         *
         * @param event event.
         */
        public void treeCollapsed(final TreeExpansionEvent event) {
        }
    }

    /**
     * Class DirSelectionListener.
     */
    class DirSelectionListener implements TreeSelectionListener {

        /**
         * Class to valued changed.
         *
         * @param event event.
         */
        public void valueChanged(final TreeSelectionEvent event) {
            DefaultMutableTreeNode node = getTreeNode(
                    event.getPath());
            FileNode fnode = getFileNode(node);
            if (fnode != null) {
                pathDir = new StringBuilder(fnode.getFile().getAbsolutePath());
            } else {
                pathDir = new StringBuilder();
            }
        }
    }

    /**
     * Method to get path dir.
     *
     * @return String.
     */
    public String getPathDir() {
        return String.valueOf(pathDir);
    }
}







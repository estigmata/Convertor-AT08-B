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

    private JTree m_tree;
    private DefaultTreeModel m_model;
    private JTextField m_display;

    public Explorer() {
        setSize(400, 300);

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

        m_model = new DefaultTreeModel(top);
        m_tree = new JTree(m_model);

        m_tree.putClientProperty("JTree.lineStyle", "Angled");

        TreeCellRenderer renderer = new
                IconCellRenderer();
        m_tree.setCellRenderer(renderer);

        m_tree.addTreeExpansionListener(new
                DirExpansionListener());

        m_tree.addTreeSelectionListener(new
                DirSelectionListener());

        m_tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        m_tree.setShowsRootHandles(true);
        m_tree.setEditable(false);

        JScrollPane s = new JScrollPane();
        s.getViewport().add(m_tree);
        add(s, BorderLayout.CENTER);

        m_display = new JTextField();
        m_display.setEditable(false);
        add(m_display, BorderLayout.NORTH);

        setVisible(true);

    }

    public DefaultMutableTreeNode getTreeNode(TreePath path) {
        return (DefaultMutableTreeNode) (path.getLastPathComponent());
    }

    public FileNode getFileNode(DefaultMutableTreeNode node) {
        if (node == null)
            return null;
        Object obj = node.getUserObject();
        if (obj instanceof IconData)
            obj = ((IconData) obj).getObject();
        if (obj instanceof FileNode)
            return (FileNode) obj;
        else
            return null;
    }

    // Make sure expansion is threaded and updating the tree model
    // only occurs within the event dispatching thread.
    class DirExpansionListener implements TreeExpansionListener {
        public void treeExpanded(TreeExpansionEvent event) {
            final DefaultMutableTreeNode node = getTreeNode(
                    event.getPath());
            final FileNode fnode = getFileNode(node);

            Thread runner = new Thread(() -> {
                if (fnode != null && fnode.expand(node)) {
                    Runnable runnable = () -> m_model.reload(node);
                    SwingUtilities.invokeLater(runnable);
                }
            });
            runner.start();
        }

        public void treeCollapsed(TreeExpansionEvent event) {
        }
    }


    class DirSelectionListener implements TreeSelectionListener {
        public void valueChanged(TreeSelectionEvent event) {
            DefaultMutableTreeNode node = getTreeNode(event.getPath());
            FileNode fnode = getFileNode(node);
            if (fnode != null){
                m_display.setText(fnode.getFile().getAbsolutePath());
            }else
            m_display.setText("");
        }
    }

    class IconCellRenderer
            extends JLabel
            implements TreeCellRenderer {
        Color m_textSelectionColor;
        Color m_textNonSelectionColor;
        Color m_bkSelectionColor;
        Color m_bkNonSelectionColor;
        Color m_borderSelectionColor;

        boolean m_selected;

        IconCellRenderer() {
            super();
            m_textSelectionColor = UIManager.getColor(
                    "Tree.selectionForeground");
            m_textNonSelectionColor = UIManager.getColor(
                    "Tree.textForeground");
            m_bkSelectionColor = UIManager.getColor(
                    "Tree.selectionBackground");
            m_bkNonSelectionColor = UIManager.getColor(
                    "Tree.textBackground");
            m_borderSelectionColor = UIManager.getColor(
                    "Tree.selectionBorderColor");
            setOpaque(false);
        }

        public Component getTreeCellRendererComponent(JTree tree,
                                                      Object value, boolean sel, boolean expanded, boolean leaf,
                                                      int row, boolean hasFocus) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) value;
            Object obj = node.getUserObject();
            setText(obj.toString());

            if (obj instanceof Boolean)
                setText("Retrieving data...");

            if (obj instanceof IconData) {
                IconData idata = (IconData) obj;
                if (expanded)
                    setIcon(idata.getExpandedIcon());
                else
                    setIcon(idata.getIcon());
            } else
                setIcon(null);

            setFont(tree.getFont());
            setForeground(sel ? m_textSelectionColor :
                    m_textNonSelectionColor);
            setBackground(sel ? m_bkSelectionColor :
                    m_bkNonSelectionColor);
            m_selected = sel;
            return this;
        }

        public void paintComponent(Graphics g) {
            Color bColor = getBackground();
            Icon icon = getIcon();

            g.setColor(bColor);
            int offset = 0;
            if (icon != null && getText() != null)
                offset = (icon.getIconWidth() + getIconTextGap());
            g.fillRect(offset, 0, getWidth() - 1 - offset,
                    getHeight() - 1);

            if (m_selected) {
                g.setColor(m_borderSelectionColor);
                g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
            }
            super.paintComponent(g);
        }
    }
}


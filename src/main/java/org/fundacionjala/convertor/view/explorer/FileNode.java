/*
 * @FileNode.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Vector;

/**
 * Class for file node used in the explorer.
 */
public class FileNode {
    private File mFile;

    /**
     * Constructor of the File node.
     *
     * @param file input
     */
    FileNode(final File file) {
        mFile = file;
    }

    /**
     * Getter of the file.
     *
     * @return the File object.
     */
    public File getFile() {
        return mFile;
    }

    /**
     * Method for convert to String.
     *
     * @return the String object.
     */
    public String toString() {
        return mFile.getName().length() > 0 ? mFile.getName()
                : mFile.getPath();
    }

    /**
     * Method for expand the tree.
     *
     * @param parent input
     * @return true or false
     */
    boolean expand(final DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode flag =
                (DefaultMutableTreeNode) parent.getFirstChild();
        if (flag == null) {   // No flag
            return false;
        }
        Object obj = flag.getUserObject();
        if (!(obj instanceof Boolean)) {
            return false;
        }      // Already expanded

        parent.removeAllChildren();  // Remove Flag

        File[] files = listFiles();
        if (files == null) {
            return true;
        }

        Vector<FileNode> v = new Vector<>();

        for (File f : files) {
            if (!(f.isDirectory())) {
                continue;
            }

            FileNode newNode = new FileNode(f);

            boolean isAdded = false;
            for (int i = 0; i < v.size(); i++) {
                FileNode nd = v.elementAt(i);
                if (newNode.compareTo(nd)) {
                    v.insertElementAt(newNode, i);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                v.addElement(newNode);
            }
        }

        for (int i = 0; i < v.size(); i++) {
            FileNode nd = v.elementAt(i);
            IconData idata = new IconData(Explorer.ICON_FOLDER,
                    Explorer.ICON_EXPANDEDFOLDER, nd);
            DefaultMutableTreeNode node = new
                    DefaultMutableTreeNode(idata);
            parent.add(node);

            if (nd.hasSubDirs()) {
                node.add(new DefaultMutableTreeNode(Boolean.TRUE));
            }
        }

        return true;
    }

    /**
     * Method for review if the node have sub directory.
     *
     * @return true or false.
     */
    private boolean hasSubDirs() {
        File[] files = listFiles();
        if (files == null) {
            return false;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for compare File node.
     *
     * @param toCompare input node
     * @return Integer
     */
    private boolean compareTo(final FileNode toCompare) {
        return toCompare.mFile.getName().equals(mFile.getName());
    }

    /**
     * Method of the files.
     *
     * @return array of files
     */
    private File[] listFiles() {
        if (!mFile.isDirectory()) {
            return null;
        }
        try {
            return mFile.listFiles();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error reading directory " + mFile.getAbsolutePath(),
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}

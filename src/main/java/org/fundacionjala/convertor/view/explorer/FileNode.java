package org.fundacionjala.convertor.view.explorer;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Vector;

/**
 * Class File Node.
 */
class FileNode {
    protected File mFile;

    /**
     * Constructor.
     *
     * @param file a File object.
     */
    FileNode(final File file) {
        this.mFile = file;
    }

    /**
     * Method to get File.
     *
     * @return a File object.
     */
    public File getFile() {
        return mFile;
    }

    /**
     * Method to String.
     *
     * @return String object.
     */
    public String toString() {
        return mFile.getName().length() > 0 ? mFile.getName() : mFile.getPath();
    }


    /**
     * Method to expand.
     *
     * @param parent a DefaultMutableTreeNode object Type.
     * @return boolean.
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
        }
        parent.removeAllChildren();
        File[] files = listFiles();
        if (files == null) {
            return true;
        }
        Vector v = new Vector();

        for (int k = 0; k < files.length; k++) {
            File f = files[k];
            if (!(f.isDirectory())) {
                continue;
            }
            FileNode newNode = new FileNode(f);

            boolean isAdded = false;
            for (int i = 0; i < v.size(); i++) {
                FileNode nd = (FileNode) v.elementAt(i);
                if (newNode.compareTo(nd) < 0) {
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
            FileNode nd = (FileNode) v.elementAt(i);
            //IconData idata = new IconData(Explorer.ICON_FOLDER,Explorer.ICON_EXPANDEDFOLDER, nd);
            DefaultMutableTreeNode node = new
                    DefaultMutableTreeNode();
            parent.add(node);

            if (nd.hasSubDirs()) {
                node.add(new DefaultMutableTreeNode(new Boolean(true)));
            }
        }

        return true;
    }

    /**
     * Method to hasSubdire.
     *
     * @return boolean.
     */

    public boolean hasSubDirs() {
        File[] files = listFiles();
        if (files == null) {
            return false;
        }
        for (int k = 0; k < files.length; k++) {
            if (files[k].isDirectory()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to compare.
     *
     * @param toCompare file Node object.
     * @return int.
     */
    int compareTo(final FileNode toCompare) {
        return mFile.getName().compareToIgnoreCase(
                toCompare.mFile.getName());
    }

    /**
     * Method to list files.
     *
     * @return File[] object.
     */

    protected File[] listFiles() {
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

package org.fundacionjala.convertor.model;

import java.io.File;
import java.util.ArrayList;


/**
 * this instance instance MediaFile instances
 */
public class MediaFileModel  {

    /**
     *
     * @param path input string showing the route
     * @return value return
     */
    public ArrayList<File> searchFiles(final String path) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        File file = new File(path);
        File[] listFiles = file.listFiles();
        for (File index : listFiles) {
            if (index.isDirectory()) {
                fileArrayList.addAll(searchFiles(index.getPath()));
            }
            fileArrayList.add(index);
            System.out.println("Path :"+index.getPath()+ " --> Name " + index.getName());

        }
        return fileArrayList;
    }
}

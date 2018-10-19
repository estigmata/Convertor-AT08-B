package org.fundacionjala.convertor.model;

import java.io.File;
import java.util.ArrayList;


/**
 * MediaFileModel.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
public class MediaFileModel {

    /**
     * @param path input string showing the route.
     * @return value return.
     */
    public ArrayList<File> searchFiles(final String path) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        File file = new File(path);
        File[] listFiles = file.listFiles();
        for (File index : listFiles != null ? listFiles : new File[0]) {
            if (index.isDirectory()) {
                fileArrayList.addAll(searchFiles(index.getPath()));
            }
            fileArrayList.add(index);
        }
        return fileArrayList;
    }
}

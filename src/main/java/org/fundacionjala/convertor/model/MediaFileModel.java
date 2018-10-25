/*
 * @MediaFileModel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class is part of the model in which files are searched from a path.
 *
 * @author Abel Gustavo Mallcu Chiri
 * @version 1.0
 */
public class MediaFileModel {

    /**
     * This Method search all the files of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     * @return return the list of the files.
     */
    public ArrayList<File> searchFiles(final Criteria criteria) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        File file = new File(criteria.getFilePath());
        File[] listFiles = file.listFiles();
        for (File index : listFiles != null ? listFiles : new File[0]) {
            if (index.isDirectory()) {
                Criteria aux = new Criteria();
                aux.setFilePath(index.getPath());
                fileArrayList.addAll(searchFiles(aux));
            }
            fileArrayList.add(index);
        }
        return fileArrayList;
    }

    /**
     * @param list List of file.
     * @param name Input parameter .
     * @return Value of return of ArrayList<File> Type.
     */
    public ArrayList<File> searchByName(final ArrayList<File> list, final String name) {
        ArrayList<File> container = new ArrayList<>();
        for (File file : list) {
            if (file.getName().equals(name)) {
                container.add(file);
            }
        }
        return container;
    }


    /**
     * @param list List of file
     * @param size Input parameter
     * @return Value of return of ArrayList<File> Type.
     */


    public ArrayList<File> searchBySize(final ArrayList<File> list, final long size) {
        ArrayList<File> container = new ArrayList<>();
        for (File file : list) {
            if (file.length() <= size) {
                container.add(file);
            }
        }
        return container;
    }

    /**
     * @param result   list of files.
     * @param size     input size.
     * @param parmeter condition.
     * @return value return.
     */

    public ArrayList<File> searchBySizeParameter(final ArrayList<File> result, final long size, final String parmeter) {

        if ("Greater than".equals(parmeter)) {
            return (ArrayList<File>) result.stream().filter(x -> x.length() > size).collect(Collectors.toList());
        } else if ("Smaller than".equals(parmeter)) {
            return (ArrayList<File>) result.stream().filter(x -> x.length() < size).collect(Collectors.toList());
        } else if ("Equal to".equals(parmeter)) {
            return (ArrayList<File>) result.stream().filter(x -> x.length() == size).collect(Collectors.toList());
        }
        return result;
    }
}

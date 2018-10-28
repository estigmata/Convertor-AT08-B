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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class is part of the model in which files are searched from a path.
 * <p>
 * //For use the array of the result and print in the table, you can use this following code:
 * //    Object[] resultTable = mediaFileModel.getResultArray();
 * //        for (Object item :resultTable) {
 * //        table.addRow((Object[]) item);
 * //    }
 * // DON"T FORGET IMPLEMENT THE EXCEPTIONS.
 *
 * @author Abel Gustavo Mallcu Chiri
 * @version 1.0
 */
public class MediaFileModel {
    private ArrayList<Object> path = new ArrayList<>();
    private ArrayList<Object> fileName = new ArrayList<>();
    private ArrayList<Object> size = new ArrayList<>();
    private Object[] resultArray;

    /**
     * This Method search all the files of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     */
    public void searchFiles(final Criteria criteria) throws IOException {
        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                //.filter( x -> x.getFileName().equals(criteria.getName()))
                //.filter( etc, etc)
                .forEach(item ->
                {
                    path.add(item.getParent());
                    fileName.add(item.getFileName());
                    try {
                        size.add(Files.size(item) / 1024);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        makeResultArray();
    }

    /**
     * This class make the Array of all the result to be used.
     */
    private void makeResultArray() {
        resultArray = new Object[path.toArray().length];
        for (int i = 0; i < path.toArray().length; i++) {
            resultArray[i] = new Object[]{path.toArray()[i], fileName.toArray()[i], size.toArray()[i]};
        }
    }

    /**
     * This is the getter of the array of the result.
     *
     * @return the Array of objects.
     */
    public Object[] getResultArray() {
        return resultArray;
    }
}

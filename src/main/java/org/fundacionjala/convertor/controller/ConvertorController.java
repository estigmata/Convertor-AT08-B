/*
 * @ConvertorController.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.controller;
import org.fundacionjala.convertor.model.MediaFileModel;
import org.fundacionjala.convertor.utils.Validator;
import org.fundacionjala.convertor.view.Viewer;


import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;

/**
 * Convertor.
 * @author Roger alvarez.
 */
public class ConvertorController {
    /**
     * The model of this Convertor.
     */
    private MediaFileModel mediaFileModel;
    /**
     * The view of this Convertor.
     */
    private Viewer viewer;
    /**
     * Validator.
     */
    private Validator validator;
    /**
     * Constructor.
     */
    public ConvertorController() {
        this.mediaFileModel = new MediaFileModel();
        this.viewer = new Viewer();
        this.validator = new Validator();
    }
    /**
     * Method Action converter.
     */
    public void actionConverter() {
        viewer.getSearchButton().addActionListener(e -> {
            if (validator.isPath(viewer.getPath())) {
                findFile();
            } else {
                System.out.println("It is not path!!!");
            }
        });
    }
    /**
     * Method find file.
     */
    public void findFile() {
        final int ref = 1024;
        String pathFile = viewer.getPath();
        DefaultTableModel table = viewer.getResultTable();
        ArrayList<File> files = mediaFileModel.searchFiles(pathFile);
        String fileSize = "";
        for (File file : files) {
            fileSize = (double) file.length() / (ref * ref) + "";
            table.addRow(new String[]{file.getPath(), file.getName(), getExtension(file.getName()), fileSize});
        }
    }
    /**
     * Method to obtain the extension of a file.
     * @param fileName is a file name.
     * @return Value of return of String Type.
     */
    public String getExtension(final String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0 &&  i < fileName.length() - 1) {
            extension = fileName.substring(i + 1).toLowerCase();
        }
        return extension;
    }
}

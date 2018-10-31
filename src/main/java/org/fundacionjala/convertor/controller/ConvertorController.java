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
import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.model.Criteria;
import org.fundacionjala.convertor.utils.Validator;
import org.fundacionjala.convertor.view.ErrorMessage;
import org.fundacionjala.convertor.view.Viewer;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;


/**
 * Convertor.
 *
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
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(ConvertorController.class.getName());
        try {
            this.mediaFileModel = new MediaFileModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.viewer = new Viewer();
        this.validator = new Validator();
        log.info();
    }

    /**
     * Method Action converter.
     */
    public void actionConverter() {
        viewer.getSearchButton().addActionListener(e -> {
            if (validator.isPath(viewer.getPath())) {
                System.out.println("boton");
                findFile();

            } else {
                new ErrorMessage("It is no path valid !!!");
            }
        });
    }

    /**
     * This method receives the values of the view in a criteria-type
     * object and sends them to the model to find the corresponding files
     * Method find file.
     */
    public void findFile() {
        Criteria basicCriteria = new Criteria();
        basicCriteria.setFilePath(viewer.getPath());
        basicCriteria.setFileName(viewer.getFileName());
        basicCriteria.setFileExtention(String.valueOf(viewer.getComboExtension()));
        try {
            mediaFileModel.searchFiles(basicCriteria);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[] resultTable = mediaFileModel.getResultArray();
        showFilesInTable(resultTable);

    }

    /**
     * Method for show files in table.
     *
     * @param resultTable input.
     */

    public void showFilesInTable(final Object[] resultTable) {
        DefaultTableModel table = viewer.getResultTable();
        for (Object file : resultTable) {
            table.addRow((Object[]) file);
        }

    }

    /**
     * Method to obtain the extension of a file.
     *
     * @param fileName is a file name.
     * @return Value of return of String Type.
     */
    public String getExtension(final String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0 && i < fileName.length() - 1) {
            extension = fileName.substring(i + 1).toLowerCase();
        }
        return extension;
    }
}

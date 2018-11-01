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

import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.MediaFileModel;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.utils.Validator;
import org.fundacionjala.convertor.view.ErrorMessage;
import org.fundacionjala.convertor.view.Viewer;


import java.io.IOException;
import java.util.ArrayList;


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

    private static final String VIDEO_1 = "Video";
    private static final String MULTIMEDIA_1 = "Multimedia";
    private static final String ALL_1 = "All";

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
                try {
                    findFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                new ErrorMessage("It is no path valid !!!");
            }
        });
    }

    /**
     * This method receives the values of the view in a criteria-type
     * object and sends them to the model to find the corresponding files
     * Method find file.
     *
     * @throws IOException defined IOException.
     */
    public void findFile() throws IOException {
        Criteria basicCriteria = new Criteria();
        if (viewer.getComboMultimedia().getSelectedItem().equals(ALL_1)) {
            basicCriteria.setFilePath(viewer.getPath());
            basicCriteria.setFileName(viewer.getFileName());
        }
        if (viewer.getComboMultimedia().getSelectedItem().equals(MULTIMEDIA_1)) {
            AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
            audioCriteria.setFilePath(viewer.getPath());
            audioCriteria.setFileName(viewer.getFileName());
            basicCriteria = audioCriteria;
        }

        if (viewer.getComboMultimedia().getSelectedItem().equals(VIDEO_1)) {
            AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
            videoCriteria.setFilePath(viewer.getPath());
            videoCriteria.setFileName(viewer.getFileName());
            basicCriteria = videoCriteria;
        }

        ArrayList<Asset> lista = mediaFileModel.searchFiles(basicCriteria);
        showFilesInTable(lista);
    }

    /**
     * Method for show files in table.
     *
     * @param resultTable input.
     */

    public void showFilesInTable(final ArrayList<Asset> resultTable) {
        viewer.getResultTable().setRowCount(0);
        for (Asset asset : resultTable) {
            System.out.println(asset.getFileName());
            viewer.getResultTable().addRow(new String[]{asset.getPath(),
                    asset.getFileName(), String.valueOf(asset.getFileSize())});
        }
    }
}

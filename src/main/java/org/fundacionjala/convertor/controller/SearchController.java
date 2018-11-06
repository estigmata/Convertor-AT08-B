/*
 * @SearchController.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
public class SearchController {
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

    private static final String VIDEO = "Video";
    private static final String AUDIO = "Audio";
    private static final String ALL = "All";

    /**
     * Constructor.
     */
    public SearchController() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(SearchController.class.getName());
        try {
            this.mediaFileModel = new MediaFileModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewer = new Viewer();
        viewer.initComponents();
        viewer.configWindow();
        this.validator = new Validator();
        log.info();
    }

    /**
     * Method Action converter.
     */
    public void actionSearch() {
        viewer.getSearchButton().addActionListener(e -> {
            if (validator.isPath(viewer.getPath())) {
                try {
                    findFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                new ErrorMessage("Isn't a valid path!!!");
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

        if (viewer.getComboMultimedia().getSelectedItem().equals(ALL)) {
            basicCriteria.setFilePath(viewer.getPath());
            basicCriteria.setFileName(viewer.getFileName());
            basicCriteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
        }
        if (viewer.getComboMultimedia().getSelectedItem().equals(AUDIO)) {
            AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
            audioCriteria.setFilePath(viewer.getPath());
            audioCriteria.setFileName(viewer.getFileName());
            audioCriteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
            audioCriteria.setAudioCodec(viewer.getUpperPanel().getSearchPanel().getAudioSearchPanel()
                    .getAudioCodec().getSelectedItem().toString());
            String aux = viewer.getUpperPanel().getSearchPanel().getAudioSearchPanel()
                    .getChannel().getSelectedItem().toString();
            audioCriteria.setChannels(aux.isEmpty() ? 0 : Integer.parseInt(aux));
            basicCriteria = audioCriteria;
        }

        if (viewer.getComboMultimedia().getSelectedItem().equals(VIDEO)) {
            AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();

            String[] resolution = viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel().getResolution().getSelectedItem().toString().split("\\*");
            videoCriteria.setFilePath(viewer.getPath());
            videoCriteria.setFileName(viewer.getFileName());
            videoCriteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
            videoCriteria.setAspectRatio(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getAspectRatio().getSelectedItem().toString());
            videoCriteria.setAudioCodec(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getVideoCodec().getSelectedItem().toString());
            videoCriteria.setFrameRate(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getFrameRate().getSelectedItem().toString());
            videoCriteria.setResolutionHeight(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[0]));
            videoCriteria.setResolutionWith(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[1]));
            videoCriteria.setVideoCodec(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getVideoCodec().getSelectedItem().toString());
            basicCriteria = videoCriteria;
        }

        showFilesInTable(mediaFileModel.searchFiles(basicCriteria));
    }

    /**
     * Method for show files in table.
     *
     * @param resultTable input.
     */
    public void showFilesInTable(final ArrayList<Asset> resultTable) {
        viewer.getDownPanel().getResultTablePanel().getFilesPanel().cleanPanel();
        viewer.getDownPanel().getResultTablePanel().getFilesPanel().displayFiles(resultTable);
    }
}

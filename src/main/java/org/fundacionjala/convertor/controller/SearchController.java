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

import org.fundacionjala.convertor.model.ConverterModel;

import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.Criteria.CriteriaFactory;
import org.fundacionjala.convertor.model.MediaFileModel;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.AbstractLogger;
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
    private ConverterModel converterModel;
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

    private CriteriaFactory criteriaFactory;

    /**
     * Constructor.
     */
    public SearchController() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(SearchController.class.getName());
        try {
            this.mediaFileModel = new MediaFileModel();
            this.converterModel = new ConverterModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        viewer = new Viewer();
        viewer.initComponents();
        viewer.configWindow();
        this.validator = new Validator();
        criteriaFactory = new CriteriaFactory();
        log.info("Search controller.");
    }

    /**
     * Method Action converter.
     */
    public void actionSearch() {
        viewer.getSearchButton().addActionListener(e -> {
//            if (validator.isPath(viewer.getPath())) {
                try {
                    findFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//            } else {
//                new ErrorMessage("Isn't a valid path!!!");
//            }
        });

        viewer.getDownPanel().getConverterPanel()
                .getBasicConverterPanel().getConverterButton().addActionListener(e -> {

            try {
                convertFile();
            } catch (IOException e1) {
                e1.printStackTrace();
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
        if (viewer.getComboMultimedia().getSelectedItem().equals(ALL)) {
            Criteria criteria = criteriaFactory.createCriteria(ALL);
            criteria.setInputPath(viewer.getPath());
            criteria.setFileName(viewer.getFileName());
            criteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
            showFilesInTable(mediaFileModel.searchFiles(criteria));
        }
        if (viewer.getComboMultimedia().getSelectedItem().equals(AUDIO)) {
            AdvancedCriteriaAudio criteria = (AdvancedCriteriaAudio) criteriaFactory.createCriteria(AUDIO);
            criteria.setInputPath(viewer.getPath());
            criteria.setFileName(viewer.getFileName());
            criteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
            criteria.setAudioCodec(viewer.getUpperPanel().getSearchPanel().getAudioSearchPanel()
                    .getAudioCodec().getSelectedItem().toString());
            String aux = viewer.getUpperPanel().getSearchPanel().getAudioSearchPanel()
                    .getChannel().getSelectedItem().toString();
            criteria.setChannels(aux.isEmpty() ? 0 : Integer.parseInt(aux));
            showFilesInTable(mediaFileModel.searchFiles(criteria));
        }

        if (viewer.getComboMultimedia().getSelectedItem().equals(VIDEO)) {
            AdvancedCriteriaVideo criteria = (AdvancedCriteriaVideo) criteriaFactory.createCriteria(VIDEO);
            String[] resolution = viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getResolution().getSelectedItem().toString().split("\\*");
            criteria.setInputPath(viewer.getPath());
            criteria.setFileName(viewer.getFileName());
            criteria.setFileSize(viewer.getSizeField().isEmpty() ? 0 : Long.parseLong(viewer.getSizeField()));
            criteria.setAspectRatio(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getAspectRatio().getSelectedItem().toString());
            criteria.setAudioCodec(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getAudioCodec().getSelectedItem().toString());
            criteria.setFrameRate(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getFrameRate().getSelectedItem().toString());
            criteria.setResolutionWith(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[0]));
            criteria.setResolutionHeight(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[1]));
            criteria.setVideoCodec(viewer.getUpperPanel().getSearchPanel().getVideoSearchPanel()
                    .getVideoCodec().getSelectedItem().toString());
            showFilesInTable(mediaFileModel.searchFiles(criteria));
        }
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

    /**
     * This method receives the values of the view in a criteria-type.
     * object and sends them to the model to convert the corresponding file.
     *
     * @throws IOException defined IOException.
     */

    public void convertFile() throws IOException {
        Criteria basicCriteria = new Criteria();

        if (viewer.getDownPanel().getConverterPanel().getBasicConverterPanel()
                .getMultimediaBox().getSelectedItem().equals(VIDEO)) {
            ConvertCriteriaVideo convertVideoCriteria = new ConvertCriteriaVideo();
            convertVideoCriteria.setInputPath(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getBasicConverterPanel()
                    .getCurrentPath()
                    .getText());
            convertVideoCriteria.setFileName(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getBasicConverterPanel()
                    .getOutputName()
                    .getText());
            String[] resolution = viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getResolution()
                    .getSelectedItem()
                    .toString()
                    .split("\\*");
            convertVideoCriteria.setOutputPath(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getBasicConverterPanel()
                    .getOutputPath()
                    .getText());
            convertVideoCriteria.setFrameRate(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getFrameRate()
                    .getSelectedItem()
                    .toString());
            convertVideoCriteria.setAspectRatio(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getAspectRatio()
                    .getSelectedItem()
                    .toString());
            convertVideoCriteria.setResolutionWith(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[0]));
            convertVideoCriteria.setResolutionHeight(resolution[0].isEmpty() ? 0 : Integer.parseInt(resolution[1]));
            convertVideoCriteria.setVideoCodec(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getVideoCodec()
                    .getSelectedItem()
                    .toString());
            convertVideoCriteria.setAudioCodec(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getAudioCodec()
                    .getSelectedItem()
                    .toString());
            convertVideoCriteria.setFormat(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getFormat()
                    .getSelectedItem()
                    .toString());
            convertVideoCriteria.setAudioChannels(Integer.parseInt(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getAudioChannels()
                    .getSelectedItem()
                    .toString())
            );
            convertVideoCriteria.setAudioSampleRate(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getAudioSampleRate()
                    .getSelectedItem()
                    .toString()
            );
            convertVideoCriteria.setAudioBitRate(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getVideoConverterPanel()
                    .getAudioBitRate()
                    .getSelectedItem()
                    .toString()
            );
            basicCriteria = convertVideoCriteria;

        }

        if (viewer.getDownPanel().getConverterPanel().getBasicConverterPanel()
                .getMultimediaBox().getSelectedItem().equals(AUDIO)) {
            ConvertCriteriaAudio convertAudioCriteria = new ConvertCriteriaAudio();
            convertAudioCriteria.setInputPath(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getBasicConverterPanel()
                    .getCurrentPath()
                    .getText());
            convertAudioCriteria.setFileName(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getBasicConverterPanel()
                    .getOutputName()
                    .getText());
            convertAudioCriteria.setAudioCodec(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getAudioConverterPanel()
                    .getAudioCodecConverter()
                    .getSelectedItem()
                    .toString());
            String aux = viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getAudioConverterPanel()
                    .getChannelConverter()
                    .getSelectedItem()
                    .toString();;
            convertAudioCriteria.setChannels(aux.isEmpty() ? 0 : Integer.parseInt(aux));
            convertAudioCriteria.setFormat(viewer
                    .getDownPanel()
                    .getConverterPanel()
                    .getAudioConverterPanel()
                    .getFormatCodecConverter()
                    .getSelectedItem()
                    .toString());;
            basicCriteria = convertAudioCriteria;
        }
        converterModel.convertFile(basicCriteria, viewer.getDownPanel().getConverterPanel().getProgressBarPanel());
    }
}

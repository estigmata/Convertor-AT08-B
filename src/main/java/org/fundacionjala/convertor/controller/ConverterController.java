/*
 * @ConverterController.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
import org.fundacionjala.convertor.view.Viewer;

import java.io.IOException;

/**
 * This Class makes the conversion of any media file selected with many characteristics.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class ConverterController {
    private String newFileName;
    private String frameRate;
    private String aspectRatio;
    private int resolutionWith;
    private int resolutionHeight;
    private String videoCodec;
    private String audioCodec;
    private int channels;
    private Viewer viewer;
    private MediaFileModel fileModel;

    /**
     * The constructor of this class will initiate all the pre requisites.
     *
     * @throws IOException of the walk function of the Model.
     */
    public ConverterController() throws IOException {
        viewer = new Viewer();
        fileModel = new MediaFileModel();
    }

    /**
     * This method use the button for convert the media file.
     */
    public void convert() {
        // This will contain the action listener of the Convert Button.
        // TO DO
//        new JButton().addActionListener(e -> {
//            getComponent();
//            fileModel.convert(convertCriteria);
//        });
    }

    /**
     * This method will get all the characteristic of conversion.
     */
    private void getComponent() {
//        newFileName = viewer.getUpperPane().getConverter().getFrameRate() ?
//                getFileOldName() :
//                viewer.getUpperPane().getConverter().getFrameRate();
//        frameRate = viewer.getUpperPane().getConverter().getFrameRate();
//        aspectRatio = viewer.getUpperPane().getConverter().getFrameRate();
//        resolutionWith = viewer.getUpperPane().getConverter().getFrameRate();
//        resolutionHeight = viewer.getUpperPane().getConverter().getFrameRate();
//        videoCodec = viewer.getUpperPane().getConverter().getFrameRate();
//        audioCodec = viewer.getUpperPane().getConverter().getFrameRate();
//        channels = viewer.getUpperPane().getConverter().getFrameRate();
    }
}

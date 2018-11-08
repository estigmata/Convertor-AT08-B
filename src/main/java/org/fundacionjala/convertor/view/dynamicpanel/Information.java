/*
 * @Information.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.dynamicpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.model.objectfile.AudioFileAsset;
import org.fundacionjala.convertor.model.objectfile.VideoFileAsset;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Information extends JPanel {

    public Information() {
        setBorder(BorderFactory.createTitledBorder("Information of:"));
//        setLocationRelativeTo(owner);
        this.setVisible(true);
    }

    public void showInformation(Asset file) {
        setLayout(new GridLayout(3,2));

        add(new JLabel("Path:"));
        add(new JLabel(file.getPath()));

        add(new JLabel("Size:"));
        add(new JLabel(String.valueOf(file.getFileSize())));


        add(new JLabel("Extension:"));
        add(new JLabel(file.getExtension()));

        if (file instanceof VideoFileAsset) {
            VideoFileAsset videoFileAsset = (VideoFileAsset) file;
            setLayout(new GridLayout(7,2));
            add(new JLabel("VideoCodec:"));
            add(new JLabel(videoFileAsset.getVideoCodec()));

            add(new JLabel("Resolution:"));
            add(new JLabel(videoFileAsset.getResolution()));

            add(new JLabel("Aspect Ratio:"));
            add(new JLabel(videoFileAsset.getAspectRatio()));

            add(new JLabel("Frame Rate:"));
            add(new JLabel(videoFileAsset.getFrameRate()));
        }
        if (file instanceof AudioFileAsset) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            setLayout(new GridLayout(5,2));

            add(new JLabel("Audio Codec:"));
            add(new JLabel(audioFileAsset.getAudioCodec()));

            add(new JLabel("Channels:"));
            add(new JLabel(String.valueOf(audioFileAsset.getChannels())));
        }
    }

}

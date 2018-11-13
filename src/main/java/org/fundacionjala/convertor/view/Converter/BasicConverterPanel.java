/*
 * @FinderPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
package org.fundacionjala.convertor.view.Converter;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.fundacionjala.convertor.view.BrowseChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @version 1.0
 */
public class BasicConverterPanel extends JPanel {

    private JButton btnConverter;
    private static JTextField outputPath;
    private JTextField outputName;
    private static JTextField currentPath;
    private static String fileToConvert;
    private BrowseChooser browseChooser;
    protected JComboBox<String> multimediaBox;
    private JLabel labelOutPath;
    private JLabel labelOutputName;
    private JLabel labelCurrentPath;
    private JLabel labelMultimediaBox;

    private static FFmpeg ffmpeg;
    private static FFprobe ffprobe;

    private static final String FFMPEG_PATH = "C:\\FFMpeg\\bin\\ffmpeg.exe";
    private static final String FFPROBE_PATH = "C:\\FFMpeg\\bin\\ffprobe.exe";

    /**
     * Constructor.
     */
    public BasicConverterPanel() {

        outputPath = new JTextField("");
        btnConverter = new JButton("Converter");
        outputName = new JTextField();
        currentPath = new JTextField();
        this.setVisible(true);
        browseChooser = new BrowseChooser();
        browseChooser.setPath(outputPath);
        multimediaBox = new JComboBox<>(new String[]{"Video", "Audio"});
        labelOutPath = new JLabel("Destination Path :");
        labelOutputName = new JLabel("Output File Name :");
        labelCurrentPath = new JLabel("Current Path :");
        labelMultimediaBox = new JLabel("Multimedia :");

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int four = 4;
        final int tree = 3;
        final int one = 1;
        final int two = 2;
        final int six = 6;
        TitledBorder title = BorderFactory.createTitledBorder("Output Setting");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelOutputName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelOutputName, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(outputName, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelCurrentPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelCurrentPath, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(currentPath, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        labelOutPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelOutPath, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        this.add(outputPath, bagConstraints);
        bagConstraints.gridx = two;
        bagConstraints.gridy = tree;
        this.add(browseChooser, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        labelMultimediaBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelMultimediaBox, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        this.add(multimediaBox, bagConstraints);

        bagConstraints.gridx = one;

        bagConstraints.gridy = six;

        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                converterFile();
            }
        });
        this.add(btnConverter, bagConstraints);
    }

    /**
     * @return .
     */
    public JButton getConverterButton() {
        return btnConverter;
    }

    /**
     * @return .
     */
    public JTextField getOutputPath() {
        return outputPath;
    }

    /**
     * @return .
     */
    public JTextField getOutputName() {
        return outputName;
    }

    /**
     * @return .
     */
    public JTextField getCurrentPath() {
        return currentPath;
    }

    /**
     * @return .
     */
    public BrowseChooser getBrowseChooser() {
        return browseChooser;
    }

    /**
     * @return .
     */
    public JComboBox<String> getMultimediaBox() {
        return multimediaBox;
    }

    public static void setFileToConvert(final String fileName) {
        fileToConvert = fileName;
    }

    public static void setPathSource(final String pathSource) {
        currentPath.setText(pathSource);
    }

    public static void setPathDestination(final String pathDestination) {
        outputPath.setText(pathDestination);
    }

    private void converterFile() {
        //TODO
        try {
            ffmpeg = new FFmpeg(FFMPEG_PATH);
        } catch(Exception e) {
            System.out.println(e);
        }
        try {
            ffprobe = new FFprobe(FFPROBE_PATH);
        } catch(Exception e) {
            System.out.println(e);
        }

        FFmpegBuilder builder = new FFmpegBuilder()

            .setInput(currentPath + fileToConvert)     // Filename, or a FFmpegProbeResult
            .overrideOutputFiles(true) // Override the output if it exists

            .addOutput("C:/Videos/FuryTigerVSSherman.avi")   // Filename for the destination
            .setFormat("avi")        // Format is inferred from filename, or can be set
            //.setTargetSize(250_000)  // Aim for a 250KB file

            .disableSubtitle()       // No subtiles

            .setAudioChannels(1)         // Mono audio
            .setAudioCodec("aac")        // using the aac codec
            .setAudioSampleRate(48_000)  // at 48KHz
            .setAudioBitRate(32768)      // at 32 kbit/s

            .setVideoCodec("libx264")     // Video using x264
            .setVideoFrameRate(24, 1)     // at 24 frames per second
            .setVideoResolution(640, 480) // at 640x480 resolution

            .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
            .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

// Run a one-pass encode
        executor.createJob(builder).run();
    }
}

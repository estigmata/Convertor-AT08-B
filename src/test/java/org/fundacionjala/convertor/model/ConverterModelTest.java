/*
 * @ConverterModelTest.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaVideo;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertTrue;


/**
 * Class Converter Model Test.
 * Unit tests to verify the conversion of files by different criteria.
 */
public class ConverterModelTest {
    private static final String OPATH = "src\\test\\java\\org\\fundacionjala\\convertor\\testFolder\\converted";
    private static final String IPATH = "src\\test\\java\\org\\fundacionjala\\convertor\\testFolder";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int SAMRATE = 22050;
    private static final int BITRATE = 32;
    private ConverterModel converterModel;

    /**
     * Setup.
     *
     * @throws Exception exception..
     */
    @Before
    public void setUp() throws Exception {
        converterModel = new ConverterModel();
    }

    /**
     * This test probe the video conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertVideoData() throws IOException {
        ConvertCriteriaVideo criteriaVideo = new ConvertCriteriaVideo();

        criteriaVideo.setAspectRatio("4:3");
        criteriaVideo.setAudioBitRate(String.valueOf(BITRATE));
        criteriaVideo.setAudioChannels(1);
        criteriaVideo.setAudioSampleRate(String.valueOf(SAMRATE));
        criteriaVideo.setAudioCodec("aac");
        criteriaVideo.setVideoCodec("libx264");
        criteriaVideo.setFormat("mp4");
        criteriaVideo.setFileName("test");
        criteriaVideo.setOutputPath(OPATH);
        criteriaVideo.setInputPath(IPATH + "\\" + "dolbycanyon.flv");
        criteriaVideo.setResolutionWith(WIDTH);
        criteriaVideo.setResolutionHeight(HEIGHT);
        criteriaVideo.setFrameRate("24");
        converterModel.convertData(criteriaVideo);
        File file = new File(OPATH + "\\" + "test.mp4");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }

    /**
     * This test probe the video to audio conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertVideoToAudioData() throws IOException {
        ConvertCriteriaAudio criteriaAudio = new ConvertCriteriaAudio();
        criteriaAudio.setAudioCodec("aac");
        criteriaAudio.setChannels(1);
        criteriaAudio.setAudioBitRate(BITRATE);
        criteriaAudio.setFormat("mp3");
        criteriaAudio.setAudioSampleRate(SAMRATE);
        criteriaAudio.setInputPath(IPATH + "\\" + "dolbycanyon.flv");
        criteriaAudio.setOutputPath(OPATH);
        criteriaAudio.setFileName("test");
        converterModel.convertData(criteriaAudio);
        File file = new File(OPATH + "\\" + "test.mp3");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }

    /**
     * This test probe the audio conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertAudioData() throws IOException {
        ConvertCriteriaAudio criteriaAudio = new ConvertCriteriaAudio();
        criteriaAudio.setAudioCodec("aac");
        criteriaAudio.setChannels(1);
        criteriaAudio.setAudioBitRate(BITRATE);
        criteriaAudio.setFormat("mp3");
        criteriaAudio.setAudioSampleRate(SAMRATE);
        criteriaAudio.setInputPath(IPATH + "\\" + "out.aac");
        criteriaAudio.setOutputPath(OPATH);
        criteriaAudio.setFileName("test");
        converterModel.convertData(criteriaAudio);
        File file = new File(OPATH + "\\" + "test.mp3");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }
    /**
     * This test probe the audio to wav format conversion.
     *
     * @throws IOException if exist a trouble with the ffmpeg
     */
    @Test
    public void convertAudioToWavData() throws IOException {
        ConvertCriteriaAudio criteriaAudio = new ConvertCriteriaAudio();
        criteriaAudio.setAudioCodec("aac");
        criteriaAudio.setChannels(1);
        criteriaAudio.setAudioBitRate(BITRATE);
        criteriaAudio.setFormat("wav");
        criteriaAudio.setAudioSampleRate(SAMRATE);
        criteriaAudio.setInputPath(IPATH + "\\" + "out.aac");
        criteriaAudio.setOutputPath(OPATH);
        criteriaAudio.setFileName("test");
        converterModel.convertData(criteriaAudio);
        File file = new File(OPATH + "\\" + "test.wav");
        assertTrue(file.exists());
        Files.deleteIfExists(file.toPath());
    }
}

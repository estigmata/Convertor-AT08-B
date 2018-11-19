/*
 * @ConvertVideo.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model.Criteria;

/**
 * Class of the criteria for convert the video file.
 */
public class ConvertCriteriaVideo extends Criteria {
    private int frameRate;
    private String aspectRatio;
    private int resolutionWith;
    private int resolutionHeight;
    private String videoCodec;
    private String audioCodec;
    private String format;
    private int audioSampleRate;
    private long audioBitRate;
    private String outputFile;
    private int audioChannels;

    @Override
    public void setFileName(final String fileName) {
        super.setFileName(fileName);
    }

    /**
     * @return value return.
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate value input.
     */
    public void setFrameRate(final String frameRate) {
        this.frameRate = Integer.parseInt(frameRate);
    }

    /**
     * @return value return.
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @param aspectRatio value input.
     */
    public void setAspectRatio(final String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return value return.
     */
    public int getResolutionWith() {
        return resolutionWith;
    }

    /**
     * @param resolutionWith value input.
     */
    public void setResolutionWith(final int resolutionWith) {
        this.resolutionWith = resolutionWith;
    }

    /**
     * @return value return.
     */
    public int getResolutionHeight() {
        return resolutionHeight;
    }

    /**
     * @param resolutionHeight value input.
     */
    public void setResolutionHeight(final int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }

    /**
     * @return value return.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCodec value input.
     */
    public void setVideoCodec(final String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @return value return.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * @param audioCodec value input.
     */
    public void setAudioCodec(final String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Getter of the format to convert.
     *
     * @return the Format String.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Setter of the Format to convert.
     *
     * @param format Input the format.
     */
    public void setFormat(final String format) {
        this.format = format;
    }

    /**
     * Getter of the Audio sample Rate.
     *
     * @return the String of audiosamplerate.
     */
    public int getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * Setter of the Audio Sample rate in this form .
     *
     * @param audioSampleRate input String in this form XX_XXX.
     */
    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = Integer.parseInt(audioSampleRate);
    }

    /**
     * Getter of the audio bit rate.
     *
     * @return the String audio bit rate.
     */
    public long getAudioBitRate() {
        return audioBitRate;
    }

    /**
     * Setter of the audio bit rate.
     *
     * @param audioBitRate the input audio bit rate.
     */
    public void setAudioBitRate(String audioBitRate) {
        this.audioBitRate = Long.parseLong(audioBitRate);
    }

    public String getOutputPath() {
        return outputFile;
    }

    public void setOutputPath(String outputFile) {
        this.outputFile = outputFile;
    }

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }
}

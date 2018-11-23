/*
 * @ConvertAudio.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 * Class of the criteria for convert the criteria of the audio file.
 */
public class ConvertCriteriaAudio extends Criteria {
    private int channels;
    private String audioCodec;
    private String format;
    private int audioSampleRate;
    private long audioBitRate;
    private String outputFile;

    /**
     * Getter of the Channels.
     *
     * @return the audio channels.
     */
    public int getChannels() {
        return channels;
    }

    /**
     * Setter of the audio Channels.
     *
     * @param channels Integer of Channels.
     */
    public void setChannels(final int channels) {
        this.channels = channels;
    }

    /**
     * Getter of the Audio Codec.
     *
     * @return value return.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Setter of the Audio Codec.
     *
     * @param audioCodec value input.
     */
    public void setAudioCodec(final String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Getter of the Format for conversion.
     *
     * @return the String-Format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Setter of the format conversion.
     *
     * @param format Input format.
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
    public void setAudioSampleRate(final int audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
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
    public void setAudioBitRate(final long audioBitRate) {
        this.audioBitRate = audioBitRate;
    }

    /**
     * Setter of the output path.
     *
     * @param outputFile Input of the outputFile.
     */
    public void setOutputPath(final String outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Getter of the output path.
     *
     * @return the String.
     */
    public String getOutputPath() {
        return outputFile;
    }
}

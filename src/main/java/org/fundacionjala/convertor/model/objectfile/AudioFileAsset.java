/*
 * @AudioFileAsset.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model.objectfile;

/**
 * Class of the file asset.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class AudioFileAsset extends Asset {
    private int channels;
    private String audioCodec;
    private double duration;

    /**
     * Getter of the channels of the audio.
     *
     * @return the int of the number of channels.
     */
    public int getChannels() {
        return channels;
    }

    /**
     * Getter of the audio codec.
     *
     * @return the Codec in String form.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Getter of the duration.
     *
     * @return the duration in seconds.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Setter of the channel for info.
     *
     * @param channels input Integer of channels.
     */
    public void setChannels(final int channels) {
        this.channels = channels;
    }

    /**
     * Setter of the audio codec.
     *
     * @param audioCodec input String of the audio codec.
     */
    public void setAudioCodec(final String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Setter of the duration of the audio.
     *
     * @param duration input the Double of the duration.
     */
    public void setDuration(final double duration) {
        this.duration = duration;
    }
}

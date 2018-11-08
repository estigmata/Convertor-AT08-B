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

    @Override
    public void setFileName(final String fileName) {
        super.setFileName(fileName);
    }

    /**
     * @return value return.
     */
    public int getChannels() {
        return channels;
    }

    /**
     * @param channels value input.
     */
    public void setChannels(final int channels) {
        this.channels = channels;
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
     *
     * @return .
     */
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format .
     */

    public void setFormat(final String format) {
        this.format = format;
    }
}

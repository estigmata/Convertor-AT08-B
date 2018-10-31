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

import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegStream;

import java.io.IOException;
import java.nio.file.Path;

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
}

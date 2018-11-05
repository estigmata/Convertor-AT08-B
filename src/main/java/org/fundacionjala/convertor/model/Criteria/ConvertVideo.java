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

public class ConvertVideo extends Criteria {
    private String frameRate;
    private String aspectRatio;
    private int resolutionWith;
    private int resolutionHeight;
    private String videoCodec;
    private String audioCodec;

    @Override
    public void setFileName(String fileName) {
        super.setFileName(fileName);
    }

    /**
     * @return value return.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate value input.
     */
    public void setFrameRate(final String frameRate) {
        this.frameRate = frameRate;
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
}

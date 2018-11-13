/*
 * @CriteriaVideoBuilder.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

public abstract class CriteriaVideoBuilder extends CriteriaBuilder {
    private String frameRate;
    private String aspectRatio;
    private int resolutionWith;
    private int resolutionHeight;
    private String videoCodec;
    private String audioCodec;

    public abstract CriteriaVideoBuilder buildFrameRate(String frameRate);

    public abstract CriteriaVideoBuilder buildAspectRatio(String aspectRatio);

    public abstract CriteriaVideoBuilder buildWidth(int resolutionWith);

    public abstract CriteriaVideoBuilder buildHeight(int resolutionHeight);

    public abstract CriteriaVideoBuilder buildVideoCodec(String videoCodec);

    public abstract CriteriaVideoBuilder buildAudioCodec(String audioCodec);
}

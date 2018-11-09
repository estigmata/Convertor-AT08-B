/*
 * @AssetFactory.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 * This class is the factory of Asset for make easier the creation of the objects.
 */
public class AssetFactory {
    /**
     * This method return the specific asset for resolver the problem of the creation objects.
     *
     * @param typeAsset Input of kind of asset.
     * @return the Specific Asset.
     */
    public Asset createAsset(final String typeAsset) {
        if (typeAsset.equals("Audio")) {
            return new AudioFileAsset();
        }
        if (typeAsset.equals("Video")) {
            return new VideoFileAsset();
        }
        return new Asset();
    }
}

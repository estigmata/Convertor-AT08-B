
/*
 * @Style.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.utils;

import java.awt.Color;
import java.awt.Font;

/**
 * Class Style.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class Style {
    private final int size = 10;
    private final int red = 255;
    private final int green = 51;
    private final int black = 0;
    private Color orange = new java.awt.Color(red, green, black);
    private Font font = new Font("Calibri", Font.BOLD, size);

    /**
     * @return .
     */
    public Color getOrange() {
        return orange;
    }

    /**
     * @return .
     */
    public Font getFont() {
        return font;
    }

}


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
    private static final int SIZE = 10;
    private static final int RED = 255;
    private static final int GREEN = 51;
    private static final int BLACK = 0;
    private Color orange = new java.awt.Color(RED, GREEN, BLACK);
    private Font font = new Font("Calibri", Font.BOLD, SIZE);

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

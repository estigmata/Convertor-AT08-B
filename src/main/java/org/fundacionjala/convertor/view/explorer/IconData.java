/*
 * @IconData.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.explorer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class of the Icon Data.
 */
public class IconData {
    protected Icon mIcon;
    protected Icon mExpandedIcon;
    protected Object mData;

    /**
     * Constructor of this class
     *
     * @param iconComputer input
     * @param icon         input
     * @param data         input
     */
    public IconData(final ImageIcon iconComputer, final Icon icon, final Object data) {
        mIcon = icon;
        mExpandedIcon = null;
        mData = data;
    }

    /**
     * Constructor with other parameters.
     *
     * @param icon         input
     * @param expandedIcon input
     * @param data         input
     */
    public IconData(final Icon icon, final Icon expandedIcon, final Object data) {
        mIcon = icon;
        mExpandedIcon = expandedIcon;
        mData = data;
    }

    /**
     * Getter of the Icon.
     *
     * @return the Icon object
     */
    public Icon getIcon() {
        return mIcon;
    }

    /**
     * Getter of the expanded icon.
     *
     * @return the Icon object
     */
    public Icon getExpandedIcon() {
        return mExpandedIcon != null ? mExpandedIcon : mIcon;
    }

    /**
     * Getter of the Object.
     *
     * @return the object
     */
    public Object getObject() {
        return mData;
    }

    /**
     * Getter of the String.
     *
     * @return String object
     */
    public String toString() {
        return mData.toString();
    }
}

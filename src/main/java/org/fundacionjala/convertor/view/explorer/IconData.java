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

public class IconData {
    protected Icon m_icon;
    protected Icon m_expandedIcon;
    protected Object m_data;

    public IconData(ImageIcon iconComputer, Icon icon, Object data) {
        m_icon = icon;
        m_expandedIcon = null;
        m_data = data;
    }

    public IconData(Icon icon, Icon expandedIcon, Object data) {
        m_icon = icon;
        m_expandedIcon = expandedIcon;
        m_data = data;
    }

    public Icon getIcon() {
        return m_icon;
    }

    public Icon getExpandedIcon() {
        return m_expandedIcon != null ? m_expandedIcon : m_icon;
    }

    public Object getObject() {
        return m_data;
    }

    public String toString() {
        return m_data.toString();
    }
}

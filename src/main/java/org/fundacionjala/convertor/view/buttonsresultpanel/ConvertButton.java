/*
 * @ConvertButton.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.buttonsresultpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;

import javax.swing.JButton;

/**
 * Class for convert the file in the dynamic panel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class ConvertButton extends JButton {
    /**
     * Constructor for the button for the conversion.
     *
     * @param file input of the list.
     */
    public ConvertButton(final Asset file) {
        this.setText("[Convert]");
        this.addActionListener(x -> {
//            System.out.println("Convert this:"+file.getPath()+"\\"+file.getFileName()+"."+file.getExtension());
        });
    }
}

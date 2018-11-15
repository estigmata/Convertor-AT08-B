/**
 * @Files.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.dynamicpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.view.Converter.BasicConverterPanel;
import org.fundacionjala.convertor.view.MediaPlayerPanel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class its the personal panel for each file and uses Mouse Listener for update the information in the
 * information panel.
 * 
 * @author Nestor Otondo.
 * @version 1.0
 */
public class Files extends JPanel implements MouseListener {
    private final Color orangeColor = new java.awt.Color(255, 51, 0);
    private MatteBorder borderDefault = new MatteBorder(1, 1, 1, 1, Color.white);
    private Border borderSelected = BorderFactory.createLineBorder(orangeColor);
    private Boolean isHighLighted;
    private Asset file;

    /**
     * The constructor who start the panel.
     *
     * @param file input.
     */
    Files(final Asset file) {
        addMouseListener(this);
        setFocusable(true);
        isHighLighted = false;
        this.file = file;
        this.setBackground(Color.white);

    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        if (isHighLighted) {
            setBorder(borderDefault);
        } else {
            setBorder(borderSelected);
        }
        isHighLighted = !isHighLighted;
        MediaPlayerPanel.setFilePath(file.getPath() + "\\" + file.getFileName() + "." + file.getExtension());
        Information.setInformation(file);
        BasicConverterPanel.setFileToConvert(file.getFileName() + "." + file.getExtension());
        BasicConverterPanel.setPathSource(file.getPath()+"\\"+file.getFileName() + "." + file.getExtension());
        BasicConverterPanel.setPathDestination(file.getPath());
    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {
    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {
    }
}

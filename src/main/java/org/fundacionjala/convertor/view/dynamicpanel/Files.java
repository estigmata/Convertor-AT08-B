/**
 * @Files.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */

package org.fundacionjala.convertor.view.dynamicpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.Validator;
import org.fundacionjala.convertor.view.Converter.BasicConverterPanel;
import org.fundacionjala.convertor.view.MediaPlayerPanel;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Paths;

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
    private Validator validator;
    private String absoutePath;

    /**
     * The constructor who start the panel.
     *
     * @param file input.
     */
    Files(final Asset file) {
        validator = new Validator();
        addMouseListener(this);
        setFocusable(true);
        isHighLighted = false;
        this.file = file;
        this.setBackground(Color.white);
        absoutePath = file.getPath() + "\\" + file.getFileName() + "." + file.getExtension();

    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        if (isHighLighted) {
            setBorder(borderDefault);
        } else {
            setBorder(borderSelected);
        }
        isHighLighted = !isHighLighted;
        MediaPlayerPanel.setFilePath(absoutePath);
        Information.setInformation(file);
        BasicConverterPanel.setOutputFileName(file.getFileName());
        BasicConverterPanel.setPathSource(absoutePath);
        BasicConverterPanel.setPathDestination(file.getPath());

        if (validator.isVideo(Paths.get(absoutePath))) {
            BasicConverterPanel.getConverterButton().setVisible(true);
            String[] items = {"Video", "Audio"};
            BasicConverterPanel.getMultimediaBox().setModel(new DefaultComboBoxModel<>(items));
        }
        if (validator.isAudio(Paths.get(absoutePath))) {
            BasicConverterPanel.getConverterButton().setVisible(true);
            String[] items = {"Audio"};
            BasicConverterPanel.getMultimediaBox().setModel(new DefaultComboBoxModel<>(items));
        }
        if (!validator.isVideo(Paths.get(absoutePath)) && !validator.isAudio(Paths.get(absoutePath))) {
            BasicConverterPanel.getConverterButton().setVisible(false);
        }
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

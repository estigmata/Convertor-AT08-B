/*
 * @ConvertorController.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.controller;
import org.fundacionjala.convertor.model.MediaFileModel;
import org.fundacionjala.convertor.view.Viewer;


import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;

/**
 * Convertor.
 * @author Roger alvarez.
 */
public class ConvertorController {
    /**
     * The model of this Convertor.
     */
   private MediaFileModel mediaFileModel;

    /**
     * Constructor.
     */
    private Viewer viewer;
    /**
     * The view of this Convertor.
     */
    public ConvertorController() {
        this.mediaFileModel = new MediaFileModel();
        this.viewer = new Viewer();
    }
    /**
     * Method Action converter.
     */
    public void actionConverter() {
        viewer.getSearchButton().addActionListener(e -> {
            findFile();
            System.out.println("push");
        });
    }
    /**
     * Method find file.
     */
    public void findFile() {
        String pathFile = viewer.getPath();
        System.out.println(pathFile);
        DefaultTableModel table = viewer.getResultTable();
        //Paths.get(pathFile);
        ArrayList<File> files = mediaFileModel.searchFiles(pathFile);
        for (File file : files) {
            table.addRow(new String[]{file.getPath(), file.getName()});
            System.out.println(file.getName() + " " + file.getPath());
        }
        //C:/Users/Admin/Desktop/AUDIOS_INGLES
        //C:/Users/Admin/Desktop/SUTW1
        //viewer.showFile();
    }
}

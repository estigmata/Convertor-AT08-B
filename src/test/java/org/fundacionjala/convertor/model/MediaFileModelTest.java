/*
 * @MediaFileModelTest.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class MediaFileModelTest {

    @Test
    public void searchFiles() throws IOException {
        Path source = Paths.get("C:\\testmultimedia\\1kHz_44100Hz_16bit_30sec.wav");
        System.out.println(Files.probeContentType(source));
        Path source1 = Paths.get("C:\\testmultimedia\\organfinale.mp3");
        System.out.println(Files.probeContentType(source1));
        Path source2 = Paths.get("C:\\testmultimedia\\bars_100.avi");
        System.out.println(Files.probeContentType(source2));
        Path source3 = Paths.get("C:\\testmultimedia\\Test_Design_Report2_RodrigoMenacho.docx");
        System.out.println(Files.probeContentType(source3));
        Path source4 = Paths.get("C:\\testmultimedia\\Hola.txt");
        System.out.println(Files.probeContentType(source4));}
}
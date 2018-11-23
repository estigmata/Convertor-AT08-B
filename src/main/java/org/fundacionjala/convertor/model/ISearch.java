/*
 * @ISearch.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface for the finder of files.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public interface ISearch {
    /**
     * This Method search all the fileList of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     * @return The Array list.
     * @throws IOException Exception.
     */
    ArrayList<Asset> searchFiles(Criteria criteria) throws IOException;
}

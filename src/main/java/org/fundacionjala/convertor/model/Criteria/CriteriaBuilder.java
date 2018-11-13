/*
 * @CriteriaBuilder.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model.Criteria;

public class CriteriaBuilder {
    String fileName;
    String filePath;
    long fileSize;

    protected Criteria criteria;

    public Criteria getCriteria() {
        return criteria;
    }

    public CriteriaBuilder buildFileName(String fileName) {
        this.fileName=fileName;
        return this;
    }

    public CriteriaBuilder buildFilePath(String filePath) {
        this.filePath=filePath;
        return this;
    }

    public CriteriaBuilder buildFileSize(long fileSize) {
        this.fileSize=fileSize;
        return this;
    }

    public Criteria build() {
        return new Criteria(this);
    }
}

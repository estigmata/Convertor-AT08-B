/*
 * @CriteriaFactory.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

/**
 * Class for make Factory for resolve the problem for create objects.
 */
public class CriteriaFactory {
    /**
     * Method for create the type of criteria.
     *
     * @param criteriaType String input of the Criteria.
     * @return the object Criteria.
     */
    public Criteria createCriteria(final String criteriaType) {
        if (criteriaType.equals("Audio")) {
            return new AdvancedCriteriaAudio();
        }
        if (criteriaType.equals("Video")) {
            return new AdvancedCriteriaVideo();
        }
        if (criteriaType.equals("Audio Convert")) {
            return new ConvertCriteriaAudio();
        }
        if (criteriaType.equals("Video Convert")) {
            return new ConvertCriteriaVideo();
        }
        return new Criteria();
    }
}

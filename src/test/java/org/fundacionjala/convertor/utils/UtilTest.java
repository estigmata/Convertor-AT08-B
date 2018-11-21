/*
 * @ValidatorTest.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Unit Test for the Util class.
 * @author Roger alvarez.
 *
 */
public class UtilTest {
    private Util util;

    /**
     * Setup.
     *
     */
    @Before
    public void setUp() {
        util = new Util();
    }

    /**
     * Test 1.
     * Method: getStringName.
     * Unit test to verify if it extracts only the name "out" from the string "out.aac".
     */
    @Test
    public void testGetStringNameFileTrue() {
        String file = "out.aac";
        assertEquals("out", util.getStringName(file));
    }

    /**
     * Test 2.
     * Method: getStringName.
     * Unit test to verify that the method does not extract the name without extension.
     */
    @Test
    public void testGetStringNameNotFileNotEqualsToUnexpected() {
        String file = "out";
        assertNotEquals("out", util.getStringName(file));
    }

    /**
     * Test 3.
     * Method: getExtensionName.
     * Unit test to verify if it extracts only the extension "mpg" from the "small.mpg" file name.
     */
    @Test
    public void testGetExtensionNameFileEqualToExpected() {
        String file = "small.mpg";
        assertEquals("mpg", util.getExtension(file));
    }

    /**
     * Test 4.
     * Method: getExtensionName.
     * Unit test to verify that the method does not extract the extension without extension.
     */
    @Test
    public void testGetExtensionNameFileNotEqualToUnexpected() {
        String file = "mpg";
        assertNotEquals("mpg", util.getExtension(file));
    }

    /**
     * Test 5.
     * Method: getWidth.
     * Unit test to verify that the method extracts the width "1280" from the resolution "1280*720".
     */
    @Test
    public void testGetWidthResolutionEqualTo1280() {
        String resolution = "1280*720";
        final int expected = 1280;
        assertEquals(expected, util.getWidth(resolution));
    }

    /**
     * Test 6.
     * Method: getHeight.
     * Unit test to verify that the method extracts the height "720" from the resolution "1280*720".
     */
    @Test
    public void testGetHeightResolutionEqualTo720() {
        String resolution = "1280*720";
        final int expected = 720;
        assertEquals(expected, util.getHeight(resolution));
    }
}

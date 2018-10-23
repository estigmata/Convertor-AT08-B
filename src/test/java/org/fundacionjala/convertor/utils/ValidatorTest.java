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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Unit Test for the Validator class.
 * @author Roger alvarez.
 *
 */
public class ValidatorTest {

    private Validator validator;
    /**
     * SETUP.
     *
     */
    @Before
    public void setUp() {
        validator = new Validator();
    }
    /**
     * Test1.
     * Method: isString().
     * Unit Test is String a String.
     *
     */
    @Test
    public void stringIsAString() {
        String actualValue = "Hello 123o bye.";
        assertTrue(validator.isString(actualValue));
    }
    /**
     * Test2.
     * Method: isString().
     * Unit Test is int a String.
     *
     */
    @Test
    public void intNotIsAString() {
        final int actualValue = 123;
        assertFalse(validator.isString(actualValue));
    }
    /**
     * Test3.
     * Method: isString().
     * is char a String.
     *
     */
    @Test
    public void charNotIsAString() {
        char actualValue = 'a';
        assertFalse(validator.isString(actualValue));
    }
    /**
     * Test4.
     * Method: isString().
     * Is Array list a String.
     *
     */
    @Test
    public void arrayNotIsAString() {
        String[] actualValue = {"asd", "123", "q123"};
        assertFalse(validator.isString(actualValue));
    }
    /**
     * Test5.
     * Method: isInt().
     * String is a int type numbers.
     *
     */
    @Test
    public void stringNumbersIsAInt() {
        String actualValue = "123456789";
        assertTrue(validator.isInt(actualValue));
    }
    /**
     * Test6.
     * Method: isInt().
     * String is not a int type numbers.
     *
     */
    @Test
    public void stringNumberAndCharsNotIsAInt() {
        String actualValue = "a23456789";
        assertFalse(validator.isInt(actualValue));
    }
    /**
     * Test7.
     * Method: isPath().
     * String is a valid path.
     *
     */
    @Test
    public void isValidPathTrue() {
        String actualValue = "C:\\Users\\Admin\\Desktop\\AUDIOS_INGLES";
        assertTrue(validator.isPath(actualValue));
    }
    /**
     * Test8.
     * Method: isPath().
     * String is not a valid path.
     *
     */
    @Test
    public void isValidPathFalse() {
        String actualValue = "\\Users\\Admin\\esktop\\AUDIOS_INGLES";
        assertFalse(validator.isPath(actualValue));
    }

}
package org.fundacionjala.convertor.model;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */

public class MediaFileModelTest {
    MediaFileModel instance;

    /**
     * this method create instance of MediaFileModel
     */
    @Before
    public void before() {
        instance = new MediaFileModel();
    }

    /**
     * this method view all files of path
     */
    @Test
    public void testSearchFile() {
        instance.searchFiles("C:\\test\\New folder\\uuu\\");
    }

}
package org.fundacionjala.convertor.model;

import org.junit.Test;

/**
 *
 */
public class VideoTest {

    /**
     *
     */

    @Test
    public void testVideoSearch() {
        Video video = new Video();
        video.search("test video");
    }
}
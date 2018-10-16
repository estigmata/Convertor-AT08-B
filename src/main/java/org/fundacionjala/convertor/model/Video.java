package org.fundacionjala.convertor.model;

/**
 * class video
 */
public class Video extends File {

    /**
     * this method search
     *
     * @param parameter input value
     */
    @Override
    public void search(final String parameter) {
        System.out.println("serch name " + parameter + " in video");
    }
}

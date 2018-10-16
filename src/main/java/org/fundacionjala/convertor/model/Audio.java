package org.fundacionjala.convertor.model;

/**
 * Class audio
 */
public class Audio extends File {

    /**
     * this method search
     *
     * @param parameter input value
     */
    @Override
    public void search(final String parameter) {
        System.out.println("search  name "+ parameter +" in audio");
    }
}

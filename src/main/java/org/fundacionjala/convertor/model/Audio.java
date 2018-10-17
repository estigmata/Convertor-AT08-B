package org.fundacionjala.convertor.model;

import java.io.File;

/**
 * Class audio
 */
public class Audio extends Archivo {

    /**
     * this method search
     *
     * @param parameter input value
     */
    @Override
    public String search(final String parameter) {
        File file = new File(parameter);
        System.out.println(file);
        return file.getName();
    }
}

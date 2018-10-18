package org.fundacionjala.convertor.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediaFileModelTest {
    MediaFileModel instance;
    @Before
public void  before(){
        instance=new MediaFileModel();
    }

   @Test
    public void testSearchFile(){
       instance.searchFiles("C:\\test\\New folder\\uuu\\");
    }

}
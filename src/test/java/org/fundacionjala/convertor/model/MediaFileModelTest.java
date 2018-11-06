package org.fundacionjala.convertor.model;

import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.model.objectfile.AudioFileAsset;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MediaFileModelTest {

    private MediaFileModel mediaFileModel;
    private Criteria basicCriteria;
    private AdvancedCriteriaAudio audioCriteria;
    //AdvancedCriteriaVideo videoCriteria;
    private ArrayList<Asset> fileList;

    @Before
    public void setUp() throws Exception {
        mediaFileModel = new MediaFileModel();
    }

    /**
     * Unit test.
     * @throws IOException
     */
    @Test
    public void searchFilesByPath() throws IOException {
        int numberFiles = 8;
        basicCriteria = new Criteria();
        basicCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\AUDIOS_INGLES");
        basicCriteria.setFileName("");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles,fileList.size());
    }

    @Test
    public void searchFilesBySize() throws IOException {
        Criteria basicCriteria = new Criteria();
        int numberFiles = 6;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\AUDIOS_INGLES");
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);

        /*for (Asset file :fileList) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            System.out.println(audioFileAsset.getFileName());
            System.out.println(audioFileAsset.getAudioCodec());
            System.out.println(audioFileAsset.getDuration());
            System.out.println(audioFileAsset.getFileSize());
            System.out.println(audioFileAsset.getExtension());
            System.out.println(" ");
        }*/
        assertEquals(numberFiles,fileList.size());
    }

/*
    @Test
    public void searchFilesByAudioCodec() throws IOException {
        int numberFiles = 6;
        audioCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\AUDIOS_INGLES");
        audioCriteria.setAudioCodec("mp3");
        fileList = mediaFileModel.searchFiles(audioCriteria);

        for (Asset file : fileList) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            System.out.println(audioFileAsset.getFileName());
            *//*System.out.println(audioFileAsset.getAudioCodec());
            System.out.println(audioFileAsset.getDuration());
            System.out.println(audioFileAsset.getFileSize());
            System.out.println(audioFileAsset.getExtension());
            System.out.println(" ");*//*
        }
        assertEquals(numberFiles, fileList.size());
    }*/
}
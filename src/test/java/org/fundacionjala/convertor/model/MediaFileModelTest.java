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
    private AdvancedCriteriaVideo videoCriteria;
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
        final int numberFiles = 16;
        basicCriteria = new Criteria();
        basicCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        basicCriteria.setFileName("");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles,fileList.size());
    }

    @Test
    public void searchFilesByName() throws IOException {
        int numberFiles = 1;
        basicCriteria = new Criteria();
        basicCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        basicCriteria.setFileName("como jugar contra caos");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        for (Asset file :fileList) {
            System.out.println(file.getPath());
            System.out.println(file.getFileName());
            System.out.println(file.getExtension());
            System.out.println(file.getFileSize());
            System.out.println(" ");
        }
        assertEquals(numberFiles,fileList.size());
    }

    @Test
    public void searchFilesBySize() throws IOException {
        final int numberFiles = 8;
        final int fileSize = 50000000;
        basicCriteria = new Criteria();
        basicCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        basicCriteria.setFileName("");
        basicCriteria.setFileSize(fileSize);
        fileList = mediaFileModel.searchFiles(basicCriteria);
        for (Asset file :fileList) {
            System.out.println(file.getFileName());
            System.out.println(file.getFileSize());
            System.out.println(" ");
        }
        assertEquals(numberFiles,fileList.size());
    }

   @Test
    public void searchAudioFiles() throws IOException {
        //Criteria basicCriteria = new Criteria();
        int numberFiles = 5;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);

        for (Asset file :fileList) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            System.out.println(audioFileAsset.getFileName());
            System.out.println(audioFileAsset.getChannels());
            //System.out.println(audioFileAsset.getFileName());
            /*System.out.println(audioFileAsset.getAudioCodec());
            System.out.println(audioFileAsset.getDuration());
            System.out.println(audioFileAsset.getFileSize());
            System.out.println(audioFileAsset.getExtension());*/
            System.out.println(" ");
        }
       assertEquals(numberFiles,fileList.size());
    }

    @Test
    public void searchAudioFilesByAudioCodec() throws IOException {
        int numberFiles = 1;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("wmav2");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);

        for (Asset file :fileList) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            System.out.println(audioFileAsset.getFileName());
            System.out.println(audioFileAsset.getAudioCodec());
            System.out.println(" ");
        }
        assertEquals(numberFiles,fileList.size());
    }

    @Test
    public void searchAudioFilesByChannels() throws IOException {
        int numberFiles = 1;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setFilePath("C:\\Users\\Admin\\Desktop\\multimediaPrueba");
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(1);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);

        for (Asset file :fileList) {
            AudioFileAsset audioFileAsset = (AudioFileAsset) file;
            System.out.println(audioFileAsset.getFileName());
            System.out.println(audioFileAsset.getChannels());
            System.out.println(" ");
        }
        assertEquals(numberFiles,fileList.size());
    }

}
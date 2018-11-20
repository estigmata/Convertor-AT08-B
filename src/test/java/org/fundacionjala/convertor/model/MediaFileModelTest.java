package org.fundacionjala.convertor.model;

import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Class Media File Model Test.
 */
public class MediaFileModelTest {

    private MediaFileModel mediaFileModel;
    private Criteria basicCriteria;
    private AdvancedCriteriaAudio audioCriteria;
    private AdvancedCriteriaVideo videoCriteria;
    private ArrayList<Asset> fileList;
    static final String PATH = "src\\test\\java\\org\\fundacionjala\\convertor\\testFolder";

    /**
     * Unit Test.
     * @throws Exception .
     */
    @Before
    public void setUp() throws Exception {
        mediaFileModel = new MediaFileModel();
    }

    /**
     * Unit test.
     * @throws IOException .
     */
    @Test
    public void searchFilesByPath() throws IOException {
        final int numberFiles = 40;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchFilesByName() throws IOException {
        final int numberFiles = 7;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("grb_2");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        for (Asset file :fileList) {
            System.out.println(file.getPath());
            System.out.println(file.getFileName());
            System.out.println(file.getExtension());
            System.out.println(file.getFileSize());
            System.out.println(" ");
        }
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchFilesBySize() throws IOException {
        final int numberFiles = 29;
        final int fileSize = 2000000;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("");
        basicCriteria.setFileSize(fileSize);
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
   @Test
    public void searchAudioFiles() throws IOException {
        final int numberFiles = 9;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchAudioFilesByAudioCodec() throws IOException {
        final int numberFiles = 2;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("AAC");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchAudioFilesByOneChannel() throws IOException {
        final int numberFiles = 5;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(1);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchAudioFilesByTwoChannels() throws IOException {
        final int numberFiles = 4;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(2);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchVideoFiles() throws IOException {
        final int numberFiles = 19;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchVideoByName() throws IOException {
        final int numberFiles = 5;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("small");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     *
     * @throws IOException .
     */
    @Test
    public void searchVideoBySize() throws IOException {
        final int numberFiles = 8;
        final int size = 1000000;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(size);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }
}

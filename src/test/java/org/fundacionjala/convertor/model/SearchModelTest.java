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
 * Unit tests to verify a search of files by different criteria.
 */
public class SearchModelTest {

    private SearchModel searchModel;
    private Criteria basicCriteria;
    private ArrayList<Asset> fileList;
    static final String PATH = "src\\test\\java\\org\\fundacionjala\\convertor\\testFolder";

    /**
     * Setup.
     * @throws Exception exception..
     */
    @Before
    public void setUp() throws Exception {
        searchModel = new SearchModel();
    }

    /**
     * Unit test to show that the application finds 41 files of different types in the entered path.
     * @throws IOException exception.
     */
    @Test
    public void searchFilesByPath() throws IOException {
        final int numberFiles = 41;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("");
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to show that the application finds 7 files of different types whose names are "grb_2".
     * @throws IOException exception.
     */
    @Test
    public void searchFilesByName() throws IOException {
        final int numberFiles = 7;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("grb_2");
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to prove that the application finds 29 files of any type with a size less than 2000000 bytes.
     * @throws IOException exception.
     */
    @Test
    public void searchFilesBySize() throws IOException {
        final int numberFiles = 30;
        final int fileSize = 2000000;
        basicCriteria = new Criteria();
        basicCriteria.setInputPath(PATH);
        basicCriteria.setFileName("");
        basicCriteria.setFileSize(fileSize);
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 13 audio files.
     * @throws IOException exception.
     */
   @Test
    public void searchAudioFiles() throws IOException {
        final int numberFiles = 13;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 2 audio files that have the "AAC" audio codec.
     * @throws IOException exception.
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
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 7 audio files that have a single audio channel..
     * @throws IOException exception.
     */
    @Test
    public void searchAudioFilesByOneChannel() throws IOException {
        final int numberFiles = 7;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(1);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 6 audio files that have two audio channels.
     * @throws IOException exception.
     */
    @Test
    public void searchAudioFilesByTwoChannels() throws IOException {
        final int numberFiles = 6;
        AdvancedCriteriaAudio audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setInputPath(PATH);
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(2);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);
        basicCriteria = audioCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 24 video files.
     * @throws IOException exception.
     */
    @Test
    public void searchVideoFiles() throws IOException {
        final int numberFiles = 24;
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
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 4 video files whose name is "small".
     * @throws IOException exception.
     */
    @Test
    public void searchVideoByName() throws IOException {
        final int numberFiles = 4;
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
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 11 video files that have a size smaller than 1000000 bytes.
     * @throws IOException exception.
     */
    @Test
    public void searchVideoBySize() throws IOException {
        final int numberFiles = 11;
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
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 6 files whose audio codec is "AAC".
     * @throws IOException exception.
     */
    @Test
    public void searchVideoByAudioCodec() throws IOException {
        final int numberFiles = 6;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("AAC");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 5 video files that have a frame rate equal to 30.
     * @throws IOException exception.
     */
    @Test
    public void searchVideoByFrameRate() throws IOException {
        final int numberFiles = 5;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("30");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 3 video files whose resolution is "1280 * 720".
     * @throws IOException exception.
     */
    @Test
    public void searchVideoByResolution() throws IOException {
        final int numberFiles = 3;
        final int with = 1280;
        final int height = 720;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(height);
        videoCriteria.setResolutionWith(with);
        videoCriteria.setVideoCodec("");
        basicCriteria = videoCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }

    /**
     * Unit test to verify that the application finds 10 video files whose audio codec is "H264".
     * @throws IOException exception.
     */
    @Test
    public void searchVideoByVideoCodec() throws IOException {
        final int numberFiles = 10;
        AdvancedCriteriaVideo videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setInputPath(PATH);
        videoCriteria.setFileName("");
        videoCriteria.setFileSize(0);
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("H264");
        basicCriteria = videoCriteria;
        fileList = searchModel.searchFiles(basicCriteria);
        assertEquals(numberFiles, fileList.size());
    }
}

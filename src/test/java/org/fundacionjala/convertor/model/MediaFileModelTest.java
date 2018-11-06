package org.fundacionjala.convertor.model;

import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.junit.Before;
import org.junit.Test;
import

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MediaFileModelTest {

    private MediaFileModel mediaFileModel;
    private Criteria basicCriteria;
    private AdvancedCriteriaAudio audioCriteria;
    AdvancedCriteriaVideo videoCriteria;
    private ArrayList<Asset> fileList;

    @Before
    public void setUp() throws Exception {
        mediaFileModel = new MediaFileModel();
        basicCriteria = new Criteria();
        basicCriteria.setFilePath("");
        basicCriteria.setFileName("");


        audioCriteria = new AdvancedCriteriaAudio();
        audioCriteria.setFilePath("");
        audioCriteria.setFileName("");
        audioCriteria.setAudioCodec("");
        audioCriteria.setChannels(0);
        audioCriteria.setConditionSize("");
        audioCriteria.setFileExtention("");
        audioCriteria.setFileSize(0);

        videoCriteria = new AdvancedCriteriaVideo();
        videoCriteria.setFilePath("");
        videoCriteria.setFileName("");
        videoCriteria.setAspectRatio("");
        videoCriteria.setAudioCodec("");
        videoCriteria.setFrameRate("");
        videoCriteria.setResolutionHeight(0);
        videoCriteria.setResolutionWith(0);
        videoCriteria.setVideoCodec("");
        videoCriteria.setFileSize(0);

    }

    @Test
    public void searchFilesByPath() throws IOException {
        String pathFiles = new String("C:\\Users\\Admin\\Desktop\\AUDIOS_INGLES");
        int numberFiles = 8;
        basicCriteria.setFilePath("pathFiles");
        fileList = mediaFileModel.searchFiles(basicCriteria);
        assertEquals(numberFiles,fileList.size());
    }
}
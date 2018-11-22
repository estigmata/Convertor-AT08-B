/*
 * @SearchModel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */

package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.model.objectfile.AssetFactory;
import org.fundacionjala.convertor.model.objectfile.AudioFileAsset;
import org.fundacionjala.convertor.model.objectfile.VideoFileAsset;
import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.utils.Util;
import org.fundacionjala.convertor.utils.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is part of the model in which fileList are searched from a path.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @author Rodrigo Menacho.
 * @version 1.0
 */
public class SearchModel implements ISearch {
    private FFprobe ffprobe = new FFprobe("src\\thirdparty\\ffmpeg\\bin\\ffprobe.exe");
    private AssetFactory assetFactory;

    private static final String VIDEO = "Video";
    private static final String AUDIO = "Audio";
    private static final String ALL = "All";

    private static AbstractLogger log = AbstractLogger.getInstance();

    private Validator validator;

    /**
     * Constructor for extract the files.
     *
     * @throws IOException because the Path.
     */
    public SearchModel() throws IOException {
        assetFactory = new AssetFactory();
        validator = new Validator();
        log.setLogger(SearchModel.class.getName());
        log.info("Media file model.");
    }

    /**
     * This Method search all the fileList of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     * @return The Array list.
     * @throws IOException Exception.
     */
    public ArrayList<Asset> searchFiles(final Criteria criteria) throws IOException {
        if (criteria instanceof AdvancedCriteriaVideo) {
            log.info("Advanced video criteria.");
            return searchVideo((AdvancedCriteriaVideo) criteria);
        }
        if (criteria instanceof AdvancedCriteriaAudio) {
            log.info("Advanced audio criteria.");
            return searchAudio((AdvancedCriteriaAudio) criteria);
        }
        ArrayList<Asset> fileList = new ArrayList<>();
        Files.walk(Paths.get(criteria.getInputPath())).filter(Files::isRegularFile)
                .filter(x -> criteria.getFileName().isEmpty()
                        || x.getFileName().toString().contains(criteria.getFileName()))
                .filter(x -> criteria.getFileSize() == 0
                        || isMinorSize(x, criteria.getFileSize()))
                .forEach(item -> {
                    Asset fileZ = assetFactory.createAsset(ALL);

                    fileZ.setFileName(new Util().getStringName(item.getFileName().toString()));
                    fileZ.setFileSize(item.toFile().length());
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));

                    fileList.add(fileZ);
                });
        log.info("Search Files list");
        return fileList;
    }

    /**
     * Class for search Video.
     *
     * @param criteria Advanced criteria of video.
     * @return The Array list of video file.
     * @throws IOException the exception of the walk function.
     */
    private ArrayList<Asset> searchVideo(final AdvancedCriteriaVideo criteria) throws IOException {
        final int mil = 1000;
        ArrayList<Asset> list = new ArrayList<>();
        Files.walk(Paths.get(criteria.getInputPath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty()
                        || x.getFileName().toString().contains(criteria.getFileName()))
                .filter(x -> criteria.getFileSize() == 0
                        || isMinorSize(x, criteria.getFileSize()))
//                VIDEO ADVANCED SEARCH
                .filter(x -> validator.isVideo(x))
//                Frame Rate
                .filter(x -> {
                    if (criteria.getFrameRate().isEmpty()) {
                        return true;
                    }
                    FFmpegStream stream = getStreamVideo(getStreamFFprobe(x));
                    assert stream != null;
                    return stream.avg_frame_rate.toString().split("/")[0].equals(criteria.getFrameRate());
                })
////                WxH
                .filter(x -> {
                    if (criteria.getResolutionHeight() == 0 || criteria.getResolutionWith() == 0) {
                        return true;
                    }
                    FFmpegStream stream = getStreamVideo(getStreamFFprobe(x));
                    return stream.width == criteria.getResolutionWith()
                            && stream.height == criteria.getResolutionHeight();
                })
//                Video Codec
                .filter(x -> {
                    FFmpegStream stream = getStreamVideo(getStreamFFprobe(x));
                    if (criteria.getVideoCodec().isEmpty()) {
                        return true;
                    }
                    return stream.codec_name.toUpperCase().equals(criteria.getVideoCodec());
                })
//                Audio Codec
                .filter(x -> {
                    FFmpegStream stream = getStreamAudio(getStreamFFprobe(x));
                    if (criteria.getAudioCodec().isEmpty()) {
                        return true;
                    }
                    return stream.codec_name.toUpperCase().equals(criteria.getAudioCodec());
                })
                .forEach(item -> {
                    FFmpegStream videoStream = getStreamVideo(getStreamFFprobe(item));
                    FFmpegStream audioStream = getStreamAudio(getStreamFFprobe(item));

                    VideoFileAsset fileZ = (VideoFileAsset) assetFactory.createAsset(VIDEO);

                    fileZ.setFileName(new Util().getStringName(item.getFileName().toString()));
                    fileZ.setFileSize(item.toFile().length());
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));
                    fileZ.setAspectRatio(videoStream.display_aspect_ratio);
                    int fr = Integer.parseInt(videoStream.avg_frame_rate.toString().split("/")[0]);
                    fileZ.setFrameRate(String.valueOf(fr > mil ? fr / mil : fr));
                    fileZ.setResolution(videoStream.width + "*" + videoStream.height);
                    fileZ.setVideoCodec(videoStream.codec_name);
                    fileZ.setAudioCodec(audioStream.codec_name);

                    list.add(fileZ);
                });
        log.info("Search video files list");
        return list;
    }

    /**
     * Class of the search audio.
     *
     * @param criteria Advanced criteria audio.
     * @return The Array list of audio file.
     * @throws IOException of the walk function.
     */
    private ArrayList<Asset> searchAudio(final AdvancedCriteriaAudio criteria) throws IOException {
        ArrayList<Asset> list = new ArrayList<>();
        Files.walk(Paths.get(criteria.getInputPath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty()
                        || x.getFileName().toString().contains(criteria.getFileName()))
                .filter(x -> criteria.getFileSize() == 0
                        || isMinorSize(x, criteria.getFileSize()))
                //                AUDIO ADVANCED SEARCH
                .filter(x -> validator.isAudio(x))
//        CHANNEL
                .filter(x -> {
                    FFmpegStream stream = getStreamFFprobe(x).get(0);
                    if (criteria.getChannels() == 0) {
                        return true;
                    }
                    assert stream != null;
                    return stream.channels == criteria.getChannels();
                })
                .filter(x -> {
                    FFmpegStream stream = getStreamFFprobe(x).get(0);
                    if (criteria.getAudioCodec().isEmpty()) {
                        return true;
                    }
                    return stream.codec_name.toUpperCase().equals(criteria.getAudioCodec());
                })
                .forEach(item -> {
                    FFmpegStream stream = getStreamFFprobe(item).get(0);
                    AudioFileAsset fileZ = (AudioFileAsset) assetFactory.createAsset(AUDIO);

                    fileZ.setFileName(new Util().getStringName(item.getFileName().toString()));
                    fileZ.setFileSize(item.toFile().length());
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));
                    fileZ.setAudioCodec(stream.codec_name);
                    fileZ.setChannels(stream.channels);

                    list.add(fileZ);
                });
        log.info("Search audio files list");
        return list;
    }

    /**
     * Getter of the Video Stream.
     *
     * @param list of the Stream list of ffprobe.
     * @return the video Stream.
     */
    private FFmpegStream getStreamVideo(final List<FFmpegStream> list) {
        log.info("Get stream video");
        if (list.size() > 1) {
            return String.valueOf(list.get(0).codec_type).equals("VIDEO") ? list.get(0) : list.get(1);
        }
        return list.get(0);
    }

    /**
     * Getter of the Audio Stream.
     *
     * @param list The list of Streams.
     * @return The audio Stream.
     */
    private FFmpegStream getStreamAudio(final List<FFmpegStream> list) {
        if (list.size() > 1) {
            return String.valueOf(list.get(0).codec_type).equals("AUDIO") ? list.get(0) : list.get(1);
        }
        return list.get(0);
    }

    /**
     * @param x parameter input.
     * @return value return.
     */
    private List<FFmpegStream> getStreamFFprobe(final Path x) {
        FFmpegProbeResult probeResult = null;
        try {
            probeResult = ffprobe.probe(x.toFile().getAbsolutePath());
            log.info("Using ffprobe get stream");
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }
        return probeResult != null ? probeResult.getStreams() : null;
    }

    /**
     * This class compare the Equal Size.
     *
     * @param x    The path.
     * @param size Input long for compare.
     * @return the Boolean.
     */
    private boolean isMinorSize(final Path x, final long size) {
        try {
            if (Files.size(x) <= size) {
                log.info("Compare file size.");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }
        return false;
    }
}

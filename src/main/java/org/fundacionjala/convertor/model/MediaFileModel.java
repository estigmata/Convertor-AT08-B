/*
 * @MediaFileModel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.AdvancedCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class is part of the model in which fileList are searched from a path.
 *
 * @author Abel Gustavo Mallcu Chiri
 * @version 1.0
 */
public class MediaFileModel {
    private ArrayList<Asset> fileList;
    private FFprobe ffprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");

    /**
     * Constructor for extract the files.
     *
     * @throws IOException because the Path.
     */
    public MediaFileModel() throws IOException {

    }

    /**
     * This Method search all the fileList of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     * @return The Array list.
     * @throws IOException Exception.
     */
    public ArrayList<Asset> searchFiles(final Criteria criteria) throws IOException {
        fileList = new ArrayList<>();
        if (criteria instanceof AdvancedCriteriaVideo) {
            AdvancedCriteriaVideo auxVideo = (AdvancedCriteriaVideo) criteria;
            searchVideo(auxVideo, fileList);
            return fileList;
        }
        if (criteria instanceof AdvancedCriteriaAudio) {
            AdvancedCriteriaAudio auxAudio = (AdvancedCriteriaAudio) criteria;
            searchAudio(auxAudio, fileList);
            return fileList;
        }
        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                .filter(x -> criteria.getFileName().isEmpty()
                        || criteria.getFileName().equals(new Util().getStringName(x)))
                .filter(x -> criteria.getFileSize() == 0
                        || isEqualSize(x, criteria.getFileSize()))
                .forEach(item -> {
                    Asset fileZ = new Asset();
                    fileZ.setFileName(new Util().getStringName(item));

                    try {
                        fileZ.setFileSize(Files.size(item));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));

                    fileList.add(fileZ);
                });
        return fileList;
    }

    /**
     * Class for search Video.
     *
     * @param criteria Advanced criteria of video.
     * @param list     of the Results.
     * @throws IOException the exception of the walk function.
     */
    private void searchVideo(final AdvancedCriteriaVideo criteria, final ArrayList<Asset> list) throws IOException {
        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty()
                        || criteria.getFileName().equals(new Util().getStringName(x)))
                .filter(x -> criteria.getFileSize() == 0
                        || isEqualSize(x, criteria.getFileSize()))
//                VIDEO ADVANCED SEARCH
                .filter(this::isVideo)
//                Frame Rate
                .filter(x -> {
                    if (criteria.getFrameRate().isEmpty()) {
                        return true;
                    }
                    FFmpegStream stream = getStreamFFprobe(x);
                    assert stream != null;
                    return stream.avg_frame_rate.toString().split("/")[0].equals(criteria.getFrameRate());
                })
//                Aspect Ratio
                .filter(x -> {
                    if (criteria.getAspectRatio().isEmpty()) {
                        return true;
                    }
                    FFmpegStream stream = getStreamFFprobe(x);
                    assert stream != null;
                    return stream.display_aspect_ratio.equals(criteria.getAspectRatio());
                })
////                WxH
                .filter(x -> {
                    if (criteria.getResolutionHeight() == 0 || criteria.getResolutionWith() == 0) {
                        return true;
                    }
                    FFmpegStream stream = getStreamFFprobe(x);
                    return stream.width == criteria.getResolutionWith()
                            && stream.height == criteria.getResolutionWith();
                })
//                Video Codec
                .filter(x -> {
                    FFmpegStream stream = getStreamFFprobe(x);
                    if (criteria.getVideoCodec().isEmpty()) {
                        return true;
                    }
                    return stream.codec_name.equals(criteria.getVideoCodec());
                })
                .forEach(item -> {
                    Asset fileZ = new Asset();
                    fileZ.setFileName(new Util().getStringName(item));

                    try {
                        fileZ.setFileSize(Files.size(item));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));

                    fileList.add(fileZ);
                });
    }

    /**
     * Class of the search audio.
     *
     * @param criteria Advanced criteria audio.
     * @param list     of the audio results.
     * @throws IOException of the walk function.
     */
    private void searchAudio(final AdvancedCriteriaAudio criteria, final ArrayList<Asset> list) throws IOException {
        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty()
                        || criteria.getFileName().equals(new Util().getStringName(x)))
                .filter(x -> criteria.getFileSize() == 0
                        || isEqualSize(x, criteria.getFileSize()))
                //                AUDIO ADVANCED SEARCH
                .filter(this::isAudio)
//        CHANNEL
                .filter(x -> {
                    FFmpegStream stream = getStreamFFprobe(x);
                    if (criteria.getChannels() == 0) {
                        return true;
                    }
                    assert stream != null;
                    return stream.channels == criteria.getChannels();
                })
                .forEach(item -> {
                    FFmpegStream stream = getStreamFFprobe(item);
                    FFmpegFormat format = getFormatFFprobe(item);
                    Asset fileZ = new Asset();
                    fileZ.setFileName(new Util().getStringName(item));

                    try {
                        fileZ.setFileSize(Files.size(item));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileZ.setPath(item.getParent().toString());
                    fileZ.setExtension(new Util().getExtension(item.getFileName().toString()));

                    fileList.add(fileZ);
                });
    }

    /**
     * @param x parameter input.
     * @return value return.
     */
    private FFmpegStream getStreamFFprobe(final Path x) {
        FFmpegProbeResult probeResult = null;
        try {
            probeResult = ffprobe.probe(x.getParent().toString().concat("\\" + x.getFileName().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return probeResult != null ? probeResult.getStreams().get(0) : null;
    }

    /**
     * This class is for get FFmpeg.
     *
     * @param x input Path
     * @return the FFmpegformat
     */
    private FFmpegFormat getFormatFFprobe(final Path x) {
        FFmpegProbeResult probeResult = null;
        try {
            probeResult = ffprobe.probe(x.getParent().toString().concat("\\" + x.getFileName().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return probeResult != null ? probeResult.getFormat() : null;
    }

    /**
     * This class compare the Equal Size.
     *
     * @param x    The path.
     * @param size Input long for compare.
     * @return the Boolean.
     */
    private boolean isEqualSize(final Path x, final long size) {
        try {
            if (Files.size(x) == size) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isVideo(final Path x) {
        try {
            if (Files.probeContentType(x) == null){
                return false;
            }
            return Files.probeContentType(x).split("/")[0].equals("video");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAudio(final Path x) {
        try {
            if (Files.probeContentType(x) == null){
                return false;
            }
            return Files.probeContentType(x).split("/")[0].equals("audio");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

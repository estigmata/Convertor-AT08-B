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
import org.fundacionjala.convertor.model.objectfile.Asset;

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
    private ArrayList<Object> path = new ArrayList<>();
    private ArrayList<Object> fileName = new ArrayList<>();
    private ArrayList<Object> size = new ArrayList<>();
    private ArrayList<Asset> fileList;
    private FFprobe ffprobe = new FFprobe("\\src\\thirdparty\\ffmpeg\\bin\\ffprobe.exe");
    private static final int INDEX1 = 1024;

    /**
     * Constructor for extract the files.
     *
     * @throws IOException because the Path.
     */
    public MediaFileModel() throws IOException {
        fileList = new ArrayList<>();
    }

    /**
     * This Method search all the fileList of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     * @throws IOException Exception
     */

    public ArrayList<Asset> searchFiles(final Criteria criteria) throws IOException {
        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty() ||
                        String.valueOf(x.getFileName()).equals(criteria.getFileName()))
                .filter(x -> criteria.getFileSize() == 0 || isEqualSize(x, criteria.getFileSize()))
//                VIDEO ADVANCED SEARCH
//                Frame Rate
//                .filter(x -> {
//                    if(criteria.getFrameRate().isEmpty()){
//                        return true;
//                    }
//                    FFmpegStream stream = getStreamFFprobe(x);
//                    if (stream.has_b_frames == criteria.getFrameRate) {
//                        return true;
//                    }
//                    return false;
//                })
//                Aspect Ratio
//                .filter(x -> {
//                    FFmpegStream stream = getStreamFFprobe(x);
//                    if (stream.display_aspect_ratio.equals(criteria.getAspectRatio)){
//                        return true;
//                    }
//                    return false;
//                })
//                WxH
//                .filter(x -> {
//                    FFmpegStream stream = getStreamFFprobe(x);
//                    if (stream.width == criteria.getWidth && stream.height == criteria.getHeight) {
//                        return true;
//                    }
//                    return false;
//                })
//                Video Codec
//                .filter(x -> {
//                    FFmpegStream stream = getStreamFFprobe(x);
//                    if (stream.codec_name.equals(criteria.getVideoCodec)) {
//                        return true;
//                    }
//                    return false;
//                })
//                AUDIO ADVANCED SEARCH
//                DURATION
//                .filter(x -> {
//                    FFmpegFormat format = getFormatFFprobe(x);
//                    if (format.duration==criteria.getDuration)) {
//                        return true;
//                    }
//                    return false;
//                })
//        CHANNEL
//                .filter(x -> {
//                    FFmpegStream stream = getStreamFFprobe(x);
//                    if (stream.channels==criteria.getChannels)){
//                        return true;
//                    }
//                    return false;
//                })
                .forEach(item -> {
                    Asset filex = null;
                    try {
                        filex = new Asset(item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileList.add(filex);
                });
        return fileList;
    }

    /**
     * @param x parameter input.
     * @return value return.
     */
    private FFmpegStream getStreamFFprobe(final Path x) {
        FFmpegProbeResult probeResult = null;
        try {
            probeResult = ffprobe.probe(x.getRoot().toString());
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
            probeResult = ffprobe.probe(x.getRoot().toString());
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
}

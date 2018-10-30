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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class is part of the model in which files are searched from a path.
 * <p>
 * //For use the array of the result and print in the table, you can use this following code:
 * //    Object[] resultTable = mediaFileModel.getResultArray();
 * //        for (Object item :resultTable) {
 * //        table.addRow((Object[]) item);
 * //    }
 * // DON"T FORGET IMPLEMENT THE EXCEPTIONS.
 *
 * @author Abel Gustavo Mallcu Chiri
 * @version 1.0
 */
public class MediaFileModel {
    private ArrayList<Object> path = new ArrayList<>();
    private ArrayList<Object> fileName = new ArrayList<>();
    private ArrayList<Object> size = new ArrayList<>();
    private Object[] resultArray;
    private FFprobe ffprobe = new FFprobe("C:\\gitJala\\ffmpeg-latest-win64-static\\bin\\ffprobe.exe");

    /**
     * Contructor empty.
     *
     * @throws IOException for the Path.
     */
    public MediaFileModel() throws IOException {
    }

    /**
     * This Method search all the files of a directory.
     *
     * @param criteria Its the input parameter who contains all the information for the search.
     */
    public void searchFiles(final Criteria criteria) throws IOException {

        Files.walk(Paths.get(criteria.getFilePath())).filter(Files::isRegularFile)
                //In this part will be appear all the filters for the advanced search.
                .filter(x -> criteria.getFileName().isEmpty() || x.getFileName().equals(criteria.getFileName()))
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
                .forEach(item ->
                {
                    path.add(item.getParent());
                    fileName.add(item.getFileName());
                    try {
                        size.add(Files.size(item) / 1024);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        makeResultArray();
    }

    /**
     * This class make the Array of all the result to be used.
     */
    private void makeResultArray() {
        resultArray = new Object[path.toArray().length];
        for (int i = 0; i < path.toArray().length; i++) {
            resultArray[i] = new Object[]{path.toArray()[i], fileName.toArray()[i], size.toArray()[i]};
        }
    }

    /**
     * This is the getter of the array of the result.
     *
     * @return the Array of objects.
     */
    public Object[] getResultArray() {
        return resultArray;
    }

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

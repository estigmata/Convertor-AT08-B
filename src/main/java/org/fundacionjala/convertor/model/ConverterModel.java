package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import java.io.File;
import java.io.IOException;

/**
 * Class Converter Model.
 * convert multimedia files.
 */

public class ConverterModel {
    private FFmpeg ffmpeg;
    private FFprobe ffprobe;

    private static final String FFMPEG_PATH = "C:\\ffmpeg\\bin\\ffmpeg.exe";
    private static final String FFPROBE_PATH = "C:\\ffmpeg\\bin\\ffprobe.exe";

    /**
     * Constructor.
     * @throws IOException .
     */

    public ConverterModel() throws IOException {
    }

    /**
     * Method to convert multimedia files.
     * @param criteria object.
     */
    public void convertFile(final Criteria criteria) {
        try {
            ffmpeg = new FFmpeg(FFMPEG_PATH);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ffprobe = new FFprobe(FFPROBE_PATH);
        } catch (Exception e) {
            System.out.println(e);
        }
        FFmpegBuilder builder = new FFmpegBuilder()

            .setInput(criteria.getFilePath() + "/" + criteria.getFileName())
            .overrideOutputFiles(true)

            .addOutput(criteria.getFilePath() + "/" + (criteria.getFileName().split("\\.")[0]) + ".avi")
            .setFormat("avi")

            .disableSubtitle()

            .setAudioChannels(1)
            .setAudioCodec("aac")
            .setAudioSampleRate(48_000)
            .setAudioBitRate(32768)

            .setVideoCodec("libx264")
            .setVideoFrameRate(24, 1)
            .setVideoResolution(640, 480)

            .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
            .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();
    }
}

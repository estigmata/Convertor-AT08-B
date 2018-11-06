package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Class Converter Model.
 * convert multimedia files.
 */

public class ConverterModel {
    private FFmpeg ffmpeg = new FFmpeg("C:\\ffmpeg\\bin\\ffmpeg.exe");
    private FFprobe ffprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");

    /**
     * Constructor.
     * @throws IOException .
     */

    public ConverterModel() throws IOException {
    }

    /**
     * Method to convert multimedia files.
     * @return boolean.
     */

    public boolean convertFile() {
         File file = new File("C:\\ffmpeg\\videoPrueba\\Alize - LA ISLA BONITA (EN VIVO).avi");
         final int width = 640;
         final int height = 480;
         final int frameRate = 24;
         final int audioChannels = 1;
         final int targetSize = 250000;

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(file.getAbsolutePath())
                .overrideOutputFiles(true)
                .addOutput("C:\\ffmpeg\\output.mp4")
                .setFormat("mp4")
                .setTargetSize(targetSize)

                .disableSubtitle()

                .setAudioChannels(audioChannels)
                .setAudioCodec("libfdk_aac")

                .setVideoCodec("libx264")
                .setVideoFrameRate(frameRate)
                .setVideoResolution(width, height)

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createTwoPassJob(builder).run();
        return false;
    }
}

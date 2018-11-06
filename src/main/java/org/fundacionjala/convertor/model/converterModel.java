package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;


import java.io.File;
import java.io.IOException;

public class converterModel {
    FFmpeg ffmpeg = new FFmpeg("C:\\ffmpeg\\bin\\ffmpeg.exe");

    FFprobe ffprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");

    public converterModel() throws IOException {
    }

    public boolean convertFile () {
         File file = new File("C:\\ffmpeg\\videoPrueba\\Alize - LA ISLA BONITA (EN VIVO).avi");



        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(file.getAbsolutePath())
                .overrideOutputFiles(true)
                .addOutput("C:\\ffmpeg\\output.mp4")
                .setFormat("mp4")
                .setTargetSize(250000)

                .disableSubtitle()

                .setAudioChannels(1)
                .setAudioCodec("libfdk_aac")

                .setVideoCodec("libx264")
                .setVideoFrameRate(24)
                .setVideoResolution(640, 480)

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createTwoPassJob(builder).run();
        return false;
    }

}

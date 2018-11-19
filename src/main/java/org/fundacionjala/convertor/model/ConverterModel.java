package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaAudio;
import org.fundacionjala.convertor.model.Criteria.ConvertCriteriaVideo;
import org.fundacionjala.convertor.model.Criteria.Criteria;
import org.fundacionjala.convertor.view.Converter.ProgressBarPanel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Class Converter Model.
 * convert multimedia files.
 */

public class ConverterModel {

    private FFmpeg ffmpeg;
    private FFprobe ffprobe;

    private static final String FFMPEG_PATH = "src\\thirdparty\\ffmpeg\\bin\\ffmpeg.exe";
    private static final String FFPROBE_PATH = "src\\thirdparty\\ffmpeg\\bin\\ffprobe.exe";
    private static final int ONEHUNDRED = 100;
    private static final int BYTETOKB = 1024;

    /**
     * Constructor.
     *
     * @throws IOException .
     */

    public ConverterModel() throws IOException {
    }

    /**
     * Method to convert multimedia files.
     *
     * @param criteria object.
     * @param status   is the panel of the progress bar.
     */
    public void convertFile(final Criteria criteria, final ProgressBarPanel status) {
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
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        FFmpegProbeResult in = null;

        try {
            in = ffprobe.probe(criteria.getInputPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (criteria instanceof ConvertCriteriaVideo) {
            convertVideo(criteria, in, executor, status);
        }
        if (criteria instanceof ConvertCriteriaAudio) {
            convertAudio(criteria, in, executor, status);
        }


    }

    /**
     * This method convert the video of to video or audio.
     *
     * @param criteria Its the criteria conversion.
     * @param in       its the ffproberesult input.
     * @param executor Its the executor of the ffmpeg.
     * @param status   Its the Panel of the ProgressBar.
     */
    private void convertVideo(final Criteria criteria, final FFmpegProbeResult in,
                              final FFmpegExecutor executor, final ProgressBarPanel status) {
        ConvertCriteriaVideo convertCriteria = (ConvertCriteriaVideo) criteria;
        FFmpegBuilder builder;
        if (convertCriteria.getFormat().equals("mp3")) {
            builder = new FFmpegBuilder()
                    .setInput(in)
                    .addOutput(convertCriteria.getOutputPath() + "\\" + convertCriteria.getFileName()
                            + "." + ((ConvertCriteriaVideo) criteria).getFormat())
                    .disableVideo()
                    .setAudioSampleRate(convertCriteria.getAudioSampleRate())
                    .setAudioChannels(convertCriteria.getAudioChannels())
                    .setAudioBitRate(convertCriteria.getAudioBitRate())
                    .setFormat(convertCriteria.getFormat())
                    .done();
        } else {
            builder = new FFmpegBuilder()
                    .setInput(in)
                    .overrideOutputFiles(true)
                    .addOutput(convertCriteria.getOutputPath() + "\\" + convertCriteria.getFileName()
                            + "." + ((ConvertCriteriaVideo) criteria).getFormat())
                    .setFormat(convertCriteria.getFormat())
                    .disableSubtitle()
                    .setAudioChannels(convertCriteria.getAudioChannels())
                    .setAudioCodec(convertCriteria.getAudioCodec())
                    .setAudioSampleRate(convertCriteria.getAudioSampleRate())
                    .setAudioBitRate(convertCriteria.getAudioBitRate() * BYTETOKB)
                    .setVideoCodec(convertCriteria.getVideoCodec())
                    .setVideoFrameRate(convertCriteria.getFrameRate(), 1)
                    .setVideoResolution(convertCriteria.getResolutionWith(), convertCriteria.getResolutionHeight())
                    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                    .done();
        }
        FFmpegJob job = executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            private final double durationNs = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(final Progress progress) {
                double percentage = progress.out_time_ns / durationNs;
                // Print out interesting information about the progress
                status.setValue1((int) (percentage * ONEHUNDRED));
            }
        });
        job.run();
    }

    /**
     * This method convert the audio to other formats of audio.
     *
     * @param criteria Its the criteria conversion.
     * @param in       its the ffproberesult input.
     * @param executor Its the executor of the ffmpeg.
     * @param status   Its the Panel of the ProgressBar.
     */
    private void convertAudio(final Criteria criteria, final FFmpegProbeResult in,
                              final FFmpegExecutor executor, final ProgressBarPanel status) {
        ConvertCriteriaAudio convertCriteria = (ConvertCriteriaAudio) criteria;
        FFmpegBuilder builder;

        builder = new FFmpegBuilder()
                .setInput(in)
                .addOutput(convertCriteria.getOutputPath() + "\\" + convertCriteria.getFileName()
                        + "." + convertCriteria.getFormat())
                .disableVideo()
                .setAudioSampleRate(convertCriteria.getAudioSampleRate())
                .setAudioChannels(convertCriteria.getChannels())
                .setAudioBitRate(convertCriteria.getAudioBitRate() * BYTETOKB)
                .setFormat(convertCriteria.getFormat())
                .done();
        FFmpegJob job = executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            private final double durationNs = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(final Progress progress) {
                double percentage = progress.out_time_ns / durationNs;

                // Print out interesting information about the progress
                status.setValue1((int) (percentage * ONEHUNDRED));
            }
        });
        job.run();
    }
}

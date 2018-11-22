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
import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.view.messages.CompletedMessage;
import org.fundacionjala.convertor.view.Converter.ProgressBarPanel;
import org.fundacionjala.convertor.view.messages.ErrorMessage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Class Converter Model.
 * convert multimedia files.
 */
@SuppressWarnings("PMD")

public class ConverterModel implements IConvert {

    private static final String FFMPEG_PATH = "src\\thirdparty\\ffmpeg\\bin\\ffmpeg.exe";
    private static final String FFPROBE_PATH = "src\\thirdparty\\ffmpeg\\bin\\ffprobe.exe";
    private static final int ONEHUNDRED = 100;
    private static final int BYTETOKB = 1024;

    private static AbstractLogger log = AbstractLogger.getInstance();

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
     * @param criteria for convert.
     * @throws IOException of FFmpeg search.
     */
    public void convertData(final Criteria criteria) throws IOException {
        FFmpeg ffmpeg = new FFmpeg(FFMPEG_PATH);
        FFprobe ffprobe = new FFprobe(FFPROBE_PATH);

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        FFmpegProbeResult in = null;

        try {
            log.info("FFmpeg library initialize.");
            in = ffprobe.probe(criteria.getInputPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (criteria instanceof ConvertCriteriaVideo) {
            convertVideo(criteria, in, executor);
            log.info("Video file converted.");
        }
        if (criteria instanceof ConvertCriteriaAudio) {
            convertAudio(criteria, in, executor);
            log.info("Audio file converted");
        }
    }

    /**
     * This method convert the video of to video or audio.
     *
     * @param criteria Its the criteria conversion.
     * @param in       its the ffproberesult input.
     * @param executor Its the executor of the ffmpeg.
     */
    private void convertVideo(final Criteria criteria, final FFmpegProbeResult in,
                              final FFmpegExecutor executor) {
        ConvertCriteriaVideo convertCriteria = (ConvertCriteriaVideo) criteria;
        FFmpegBuilder builder;
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
        log.info("FFmpegbuilder set data.");
        FFmpegJob job = executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            private final double durationNs = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(final Progress progress) {
                double percentage = progress.out_time_ns / durationNs;
                // Print out interesting information about the progress
                ProgressBarPanel.setValue1((int) (percentage * ONEHUNDRED));
            }
        });
        try {
            job.run();
            log.info("Run conversion job");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        if (job.getState() == FFmpegJob.State.FAILED) {
            new ErrorMessage("Maybe exists incorrect parameters for the current video codec");
        }
        if (job.getState() == FFmpegJob.State.FINISHED) {
            new CompletedMessage("Conversion Completed");
            log.info("Conversion Completed");
        }
    }

    /**
     * This method convert the audio to other formats of audio.
     *
     * @param criteria Its the criteria conversion.
     * @param in       its the ffproberesult input.
     * @param executor Its the executor of the ffmpeg.
     */
    private void convertAudio(final Criteria criteria, final FFmpegProbeResult in,
                              final FFmpegExecutor executor) {
        ConvertCriteriaAudio convertCriteria = (ConvertCriteriaAudio) criteria;
        FFmpegBuilder builder;
        if (!convertCriteria.getFormat().equals("wav")) {
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
        } else {
            builder = new FFmpegBuilder()
                    .setInput(in)
                    .addOutput(convertCriteria.getOutputPath() + "\\" + convertCriteria.getFileName()
                            + "." + convertCriteria.getFormat())
                    .done();
        }
        log.info("FFmpegbuilder set data.");
        FFmpegJob job = executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            private final double durationNs = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(final Progress progress) {
                double percentage = progress.out_time_ns / durationNs;

                // Print out interesting information about the progress
                ProgressBarPanel.setValue1((int) (percentage * ONEHUNDRED));
            }
        });
        try {
            job.run();
            log.info("Run conversion job");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        if (job.getState() == FFmpegJob.State.FAILED) {
            new ErrorMessage("Maybe exists incorrect parameters for the current audio codec");
        }
        if (job.getState() == FFmpegJob.State.FINISHED) {
            new CompletedMessage("Conversion Completed");
            log.info("Conversion Completed");
        }
    }
}

package org.fundacionjala.convertor.model;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;

import java.io.IOException;

public class TestMeta {
    public TestMeta() {
    }

    public void testProbe() throws IOException {
        FFprobe ffprobe = new FFprobe("C:/test");
        FFmpegProbeResult probeResult = ffprobe.probe("FFMusicVideoMP4_512kb.mp4");

        FFmpegFormat format = probeResult.getFormat();
        System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs",
                format.filename,
                format.format_long_name,
                format.duration
        );

        FFmpegStream stream = probeResult.getStreams().get(0);
        System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
                stream.codec_long_name,
                stream.width,
                stream.height
        );
    }

    public static void main(final String[] args) throws IOException {
        TestMeta testMeta = new TestMeta();
        testMeta.testProbe();
    }
}

package com.example.utils;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class cover {
    public static String getScreenshot(String filePath,String targetFilePath) throws Exception{

        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(filePath);

        // 视频文件名
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        // 图片名称
        String targetFileName = fileName.substring(0, fileName.lastIndexOf("."));

        grabber.start();

        Frame frame = grabber.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bi = converter.getBufferedImage(frame);
        String imageMat = "jpg";
        String imagePath = targetFilePath + File.separator + targetFileName + "." + imageMat;
        File output = new File(imagePath);
        ImageIO.write(bi, imageMat, output);

        grabber.stop();

        return output.getName();
    }


}

package com.bsoft.anthony.springbootservice.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @author lxb
 * @version 1.0.0
 * @desc:
 * @date 2020-03-17 10:36
 */
public class FileUtil {
    /**
     * 获取文件上传路径
     *
     * @return
     */
    public static String getFilePath() {
        String userDir = System.getProperty("user.dir");
        return userDir + File.separator + "upload" + File.separator;
    }

    public static byte[] fileToByte(File file) throws IOException {
        String fileName = file.getName();
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] bytes;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bi = ImageIO.read(file);
        ImageIO.write(bi, suffixName, baos);
        bytes = baos.toByteArray();
        baos.close();
        return bytes;
    }
}

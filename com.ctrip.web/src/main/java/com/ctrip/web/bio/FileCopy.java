package com.ctrip.web.bio;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class FileCopy {
    /**
     * java 7
     * @param source
     * @param dest
     * @throws IOException
     */
    private static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }


    /**
     * apache commons
     * @param source
     * @param dest
     * @throws IOException
     */
    private static void copyFileUsingApacheCommonsIO(File source, File dest)
            throws IOException {
        FileUtils.copyFile(source, dest);
    }


    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        Long start = System.currentTimeMillis();
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
            System.out.println(System.currentTimeMillis() - start);
        } finally {
            input.close();
            output.close();
        }
    }

    /**
     * NIO copy
     *
     * @param source
     * @param dest
     * @throws IOException
     */
    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        Long start = System.currentTimeMillis();
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
            System.out.println(System.currentTimeMillis() - start);
        }
    }


    public static void main(String[] args) throws IOException {
        File resource = new File("E:/新建文件夹/snnnn", "abc.txt");

        File dest = new File("E:/新建文件夹/dwwww", "abc.txt");

        copyFileUsingJava7Files(resource, dest);

        System.out.println("TTTTT");

    }
}

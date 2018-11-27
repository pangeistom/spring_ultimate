package com.ctrip.web.bio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBasic {
    public static void main(String[] args) throws IOException {
        //文件夹的路径
        String path = "E:/新建文件夹";
        //使用UUID生成文件名
        String fileName = "abc.txt";
        //文件夹不存在则新建
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        //新建文件
        File myFile = new File(path, fileName);
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();

        }
        writeContent(myFile, "写点东西试试");
        readStringContent(myFile);
        readAllToString(myFile);
    }

    public static void readByteContent(File myFile) {

    }


    public static String readAllToString(File myFile) {
        String encoding = "UTF-8";
        String str = "";
        try {
            Long length = myFile.length();
            byte[] byteContent = new byte[length.intValue()];
            FileInputStream fileInputStream = new FileInputStream(myFile);
            fileInputStream.read(byteContent);
            fileInputStream.close();
            str = new String(byteContent, encoding);
        } catch (Exception ex) {

        }
        return str;

    }


    public static void writeContent(File myFile, String message) throws IOException {
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(myFile, true)));
        out.write(message + "\r\n");
        out.close();
    }


    public static void readStringContent(File myFile) {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                stringList.add(str);
            }
            System.out.println();
            bufferedReader.close();
        } catch (Exception ex) {

        }
    }
}

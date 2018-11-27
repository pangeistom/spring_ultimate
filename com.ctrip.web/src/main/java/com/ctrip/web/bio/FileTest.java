package com.ctrip.web.bio;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径来创建一个File对象
        File file2 = new File(".");
        //直接获取文件名
        System.out.println(file2.getName());
        //获取文件相对路径的父路径,可能出错，下面返回 null
        System.out.println(file2.getParent());
        //获取绝对路径
        System.out.println(file2.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file2.getAbsoluteFile().getParent());
        System.out.println("-------------------------------------------");

        //以指定路径来创建一个File对象，例如项目中的 file/file2 文件夹为指定路径
        File file0 = new File("E:/BaiduNetdiskDownload/aaa.txt");
        /**
         //         * 在指定的路径下创建一个临时文件,,文件存放位置 file0对象对应的路径下
         //         * 使用前缀，系统随机生成的随机数和给定的后缀 作为文件名。  这是一个静态方法
         //         */
        if(!file0.exists()){
            file0.createNewFile();
        }


        File file10=new File("E:/WWWWWWWWWWWWWWWWWW");
        if(!file10.exists()){
            file0.mkdir();
        }

        File file11=new File("E:/WWWWWWWWWWWWWWWWWW");
        if(!file10.exists()){
            file0.mkdir();
        }

        File tmpFile = File.createTempFile("aaa", ".txt", file0);
        //指定JVM退出时删除该文件，钩子方法
        tmpFile.deleteOnExit();
        System.out.println("tmpFile 被删除...");
        System.out.println("-------------------------------------------");

        //以系统当前时间为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + ".txt");
        System.out.println("newFile对象是否存在： " + newFile.exists());  //返回false
        //以指定的newFile对象来创建一个文件 ，文件位置在项目名下
        newFile.createNewFile();
        //以newFile对象创建一个目录，因为newFile已存在，因此下面方法返回false，无法创建
        System.out.println(newFile.mkdir());

        /**
         * 使用list方法列出当前路径下所有文件和路径
         * 项目名下的所有文件及路径(不包括路径的子路径)
         */
        String[] fileList = file2.list();
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        System.out.println("-----------------------");
        //listRoots()静态方法列出所有的磁盘根路径:  C:\   D:\  E:\  F:\
        File[] roots = File.listRoots();
        for (File file : roots) {
            System.out.println(file);
        }
    }

}

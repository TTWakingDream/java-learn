package com.cl.files;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamDemo {


    public static void main(String[] args) throws IOException {
//        writeByteToFile("src/main/resources/static/test.txt");
//        writeBytesToFile("src/main/resources/static/test.txt");
        copyFile("src/main/resources/static/test.txt");
    }


    /**
     * 写一个字节到指定文件
     * @param path
     * @throws IOException
     */
    public static void writeByteToFile(String path) throws IOException {
        try(OutputStream os = new FileOutputStream(path)){
            os.write(111);
            os.write(112);
            os.write(113);
            os.write(114);
            os.write(10086);
        }
        System.out.println("finish");
    }


    /**
     * 写一个byte数组到文件
     * @param path
     * @throws IOException
     */
    public static void writeBytesToFile(String path) throws IOException {
        try(OutputStream os = new FileOutputStream(path)) {
            os.write("hello".getBytes(StandardCharsets.UTF_8));
            os.write("world".getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * close和flush
     */


    /**
     * try()注册多个实现autoCloseable接口的资源
     */
    public static void copyFile(String src, String dest) throws IOException {
        try(InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
        }
    }


    /**
     * 利用现有方法对文件进行copy
     */
    public static void copyFile(String src) throws IOException {
        File file = new File("src/main/resources/static", "test.txt");
        file.createNewFile();
        try(InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(file)){
            is.transferTo(os);
        }
    }

}

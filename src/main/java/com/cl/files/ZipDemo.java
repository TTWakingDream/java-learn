package com.cl.files;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 关于压缩包输入输出流的demo
 */
public class ZipDemo {


    private final static String ZIP_FILE_NAME = "d:\\Documents and Settings\\cuixin\\桌面\\tzip.zip";

    public static void main(String[] args) throws IOException {
        readZip(ZIP_FILE_NAME);
        writeToZip(ZIP_FILE_NAME);
    }

    public static void readZip(String file) throws IOException {
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry nextEntry = null;
            while ((nextEntry = zis.getNextEntry()) != null ){
                String name = nextEntry.getName();
                System.out.println("fileName: " + name);
                if(!nextEntry.isDirectory()) {
                    int n;
                    while ((n = zis.read()) != -1) {
                        System.out.println((char)n);
                    }
                }
            }
        }

    }

    public static void writeToZip(String filePath) throws IOException {
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filePath))) {
            File[] files = new File("d:\\Documents and Settings\\cuixin\\桌面\\tzip").listFiles();
            assert files != null;
            for(File file : files) {
                String name = file.getName();
                zos.putNextEntry(new ZipEntry(name.replace(".txt", "_new.text")));
                zos.write(Files.readAllBytes(file.toPath()));
                zos.closeEntry();
            }
        }
    }

}

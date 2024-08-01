package com.cl.files;

import java.io.*;

public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
//        isRead("src/main/resources/static/dragonCat.jpeg");
        readStringFromFile("src/main/resources/static/hello.txt");
//        byteArrayIsUsed();
//        bufferRead();
    }


    public static void isRead(String path) throws IOException {
        File file = new File(path);
        if(!file.exists() || !file.canRead()) {
            throw new IOException("file not exist");
        }
        System.out.println("========start==========");
        try(FileInputStream is = new FileInputStream(file)){
            int readLen = 0;
            while(readLen != -1){
                readLen = is.read();
                System.out.println("-----------> "+ readLen);
            }
        }

    }

    public static void readStringFromFile(String fileName) throws IOException {
        String s;
        try(InputStream is = new FileInputStream(fileName)){
            readAsString(is);
        }
    }

    public static void readAsString(InputStream is) throws IOException {
        int n;
        StringBuilder builder = new StringBuilder();
        while((n = is.read()) != -1){
            builder.append((char) n);
            System.out.println("++++ " +(char) n);
        }
        System.out.println(builder);
    }


    public static void byteArrayIsUsed() throws IOException {
        byte[] barr = {77,111,34,56,88};
        try(InputStream is = new ByteArrayInputStream(barr)){
            readAsString(is);
        }
    }

    public static void bufferRead() throws IOException {
        try(InputStream is = new FileInputStream("src/main/resources/static/hello.txt")) {
            byte[] buffer = new byte[1024];
            int n = 0;
            while (n != -1) {
                n = is.read(buffer);
                System.out.println("-----------> " + n + " bytes");
            }
        }
    }
}

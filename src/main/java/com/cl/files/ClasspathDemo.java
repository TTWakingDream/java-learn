package com.cl.files;

import java.io.IOException;
import java.io.InputStream;

/**
 * 从classpath读取配置文件
 */
public class ClasspathDemo {

    public static void main(String[] args) throws IOException {
        ClasspathDemo demo = new ClasspathDemo();
        demo.readFromClasspath("/default.properties");
        System.out.println("finish----------");
    }

    public void readFromClasspath(String fileName) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(fileName)){
            byte[] bytes = new byte[1024];
            int n ;
            while((n = is.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, n));
            }
        }
    }
}

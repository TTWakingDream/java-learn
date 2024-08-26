package com.cl.files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * 从classpath读取配置文件
 */
public class ClasspathDemo {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("java.class.path");
        System.out.println("classPath of system "+ path);

        ClassLoader classLoader = ClasspathDemo.class.getClassLoader();
        Enumeration<URL> resources = classLoader.getResources("");
        while(resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println("URL from classloader: " + url);
        }

        ClasspathDemo demo = new ClasspathDemo();
        demo.readFromClasspath("/default.properties");
        System.out.println("finish----------");
    }

    public void readFromClasspath(String fileName) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(fileName)){
            assert is != null;
            byte[] bytes = new byte[1024];
            int n ;
            while((n = is.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, n));
            }
        }
    }
}

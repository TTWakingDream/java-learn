package com.cl.files;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {


    public static void main(String[] args) throws IOException {
        pathDemo();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
    }

    public static void filePath() throws IOException {
        File file = new File("..");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
    }


    public static void fileList() {
        File file = new File("C:\\windows");
        File[] files = file.listFiles();
        assert files != null;
        printFiles(files);
        File[] files1 = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe");
            }
        });
        assert files1 != null;
        printFiles(files1);
    }


    private static void printFiles(File[] files){
        System.out.println("============");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("============");
    }


    public static void pathDemo(){
        Path path = Paths.get(".", "project", "study");
        System.out.println(path);
        Path abPath = path.toAbsolutePath();
        System.out.println(abPath);
        Path normalize = abPath.normalize();
        System.out.println(normalize);
        File file = normalize.toFile();
        System.out.println(file);
        Paths.get("..").toAbsolutePath().forEach(path1 ->  {
            System.out.println("    "+path1);
        });
    }
}

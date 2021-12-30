package main.java.tree;

import java.io.*;

class PrintDirectory {
    void print(File file, int count) {
        if (file.isFile()) {
            for (int i = 0; i < count; i++) {
                System.out.print("	");
            }
            System.out.println(file.getName());
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print("	");
            }
            System.out.println(file.getName());
            count++;
            File[] files = file.listFiles();
            for (File f : files) {
                print(f, count);
            }
        }
    }

    public static void main(String[] args) {
        PrintDirectory printTest = new PrintDirectory();
        File file = new File("E:\\就业准备\\数据结构与算法分析\\Homework");
        printTest.print(file, 0);
    }
}

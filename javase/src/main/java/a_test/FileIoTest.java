package main.java.a_test;

import java.io.*;

public class FileIoTest {
    public static void main(String[] args) throws IOException{
        FileReader input = new FileReader("work/test.txt");
        char[] buff = new char[1];
        int hasRead = 0;
        while ((hasRead = input.read(buff)) > 0) {
        System.out.print(new String(buff, 0, hasRead));
        }
        input.close();
        FileWriter writer = new FileWriter("Work/new.txt");
        writer.write("今天不是个好日子");
        writer.close();
    }
}

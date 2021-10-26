package i_o;

import java.io.FileReader;
import java.io.IOException;

public class IO_Test {
    public static void main(String[] args) throws IOException {
        FileReader inPut = new FileReader("datastructure\\src" + "\\a_test\\test.IO_Test.java");
        //FileWriter outPut = new FileWriter("C:\\Users\\Administrator" +
        // "\\Desktop\\Test.txt");
        char[] ch = new char[32];
        int hasRead = 0;
        while ((hasRead = inPut.read(ch)) > 0) {
            System.out.print(new String(ch, 0, hasRead));
            //outPut.write(ch , 0 , hasRead);
        }
        inPut.close();
        //outPut.close();
    }
}
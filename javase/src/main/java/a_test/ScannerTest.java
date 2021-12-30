package main.java.a_test;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (s.hasNext()){
            String tmp = s.next();
            if (tmp.equals("end")) {
                break;
            }
            set.add(tmp);
        }
        set.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }
}

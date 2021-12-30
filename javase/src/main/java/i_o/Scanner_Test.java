package main.java.i_o;

import java.util.Scanner;

public class Scanner_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = sc.next();
        //从next到nextLine时nextLine首先读取的是该行剩余的字符
        //如果该行没有字符则读取一个空字符串，不会直接读取下一行
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int j = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(i);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(j);
        System.out.println(k);
    }
}

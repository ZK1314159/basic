package wangyi;

import java.util.Scanner;

public class Main2 {
    private char[] sort(String s) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        for (int i = 1; i < s.length(); i++) {
            int j;
            char tmp = ch[i];
            for (j = i; j > 0 && tmp < ch[j - 1]; j--) {
                ch[j] = ch[j - 1];
            }
            ch[j] = tmp;
        }
        return ch;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.nextLine();

        //System.out.print();
    }
}
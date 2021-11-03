package historry.exam2019.yonyou;

import java.util.Scanner;

public class Main {
    private boolean find(String st1, String st2) {
        for (int i = 0; i < st1.length(); i++) {
            int j = i;
            int k = 0;
            while ((st1.charAt(j) == st2.charAt(k))) {
                if (k == st2.length() - 1) {
                    return true;
                }
                j++;
                k++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean b = m.find(s1, s2);
        System.out.print(b);
    }
}
package main.java.historry.exam2019.xunlei;

import java.util.Scanner;

public class Main {
    private int gcd(int n, int m) {
        while (m != 0) {
            int rem = n % m;
            n = m;
            m = rem;
        }
        return n;
    }

    private int count(int n) {
        int num = 0;
        if (n < 5) {
            return 0;
        }
        for (int i = n; i > 4; i--) {
            if (i / 2 == 0) {
                continue;
            }
            int min = (int) Math.ceil(Math.sqrt(i * i / 2.0));
            for (int j = i - 1; j >= min; j--) {
                double d = Math.sqrt(i * i - j * j);
                int l = (int) Math.sqrt(i * i - j * j);
                if (l == d) {
                    int in = gcd(j, l);
                    int in1 = gcd(in, i);
                    if (in1 == 1) {
                        num++;
                        System.out.println(i + ", " + j + ", " + l);
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = m.count(n);
        System.out.print(num);
    }
}

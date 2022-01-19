package historry.exam2018.xiecheng;

import java.util.Scanner;

public class IntToArray {
    public int[] transfer(int n) {
        int j = 1;
        int[] ints = new int[32];
        for (int i = 0; i < 32; i++) {
            if ((n & j) != 0) {
                ints[31 - i] = 1;
            } else {
                ints[31 - i] = 0;
            }
            j = j << 1;
        }
        return ints;
    }

    public static void main(String[] args) {
        IntToArray s = new IntToArray();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] in = s.transfer(t);
        System.out.print("haha");
        System.out.print("ha");
        for (int i : in) {
            System.out.print(i);
        }
    }
}
package wangyi;

import java.util.Scanner;

public class Main {
    private long find(long n) {
        long begin = 1;
        long end = n;
        return find(begin, end, n);
    }

    private long find(long begin, long end, long n) {
        if (begin == end) {
            return begin;
        } else {
            long num = n;
            long mid = (begin + end) / 2;
            long sum = 0;
            while (num >= mid) {
                num -= mid;
                num -= num / 10;
                sum += mid;
            }
            sum += num;
            if (sum >= n - n / 2) {
                return find(begin, mid, n);
            } else {
                return find(mid + 1, end, n);
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        long aim = m.find(n);
        System.out.print(aim);
    }
}

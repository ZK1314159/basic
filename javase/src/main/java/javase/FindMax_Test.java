package javase;

import java.util.Arrays;

public class FindMax_Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 9, 3, 6};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
    }
}

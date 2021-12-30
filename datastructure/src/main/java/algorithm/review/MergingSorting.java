package main.java.algorithm.review;

import java.util.Arrays;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/10 10:18 <br>
 */
public class MergingSorting {


    void sort(int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        core(ints, start, end);
    }

    void core(int[] ints, int start, int end) {
        int medium = (start + end) / 2;
        if (end - start <= 3) {
            for (int i = start + 1; i <= end; i++) {
                int tmp = ints[i];
                int j;
                for (j = i - 1; j >= start; j--) {
                    if (ints[j] > tmp) {
                        ints[j + 1] = ints[j];
                    }
                    else {
                        break;
                    }
                }
                ints[j + 1] = tmp;
            }
        }
        else {
            core(ints, start, medium);
            core(ints, medium + 1, end);
            merge(ints, start, medium, end);
        }
    }

    //忘记了方法的入参中引用只是一个临时变量，和本体是不一样的
    void merge(int[] ints, int start, int medium, int end) {
        int[] tmp = Arrays.copyOf(ints, ints.length);
        int position = start;
        //忽视了内层循环变量的值会重置
        for (int i = start, j = medium + 1; i <= medium && j <= end; ) {
            if (ints[i] <= ints[j]) {
                tmp[position] = ints[i];
                position++;
                i++;
                if (i == medium + 1) {
                    for (; j <= end; j++) {
                        tmp[position] = ints[j];
                        position++;
                    }
                    break;
                }
            }
            else {
                tmp[position] = ints[j];
                position++;
                j++;
                if (j == end + 1) {
                    for (; i <= medium; i++) {
                        tmp[position] = ints[i];
                        position++;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            ints[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        MergingSorting test = new MergingSorting();
        //int[] ints = {1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 7, 9, 5, 2, 3};
        int[] ints = {9, 3, 4, 6, 7, 2, 3, 6, 34, 13, 32, 67, 99, 12, 24};
        //int[] ints = {9, 7};
        test.sort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

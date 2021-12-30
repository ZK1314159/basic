package main.java.algorithm.review;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/8 9:39 <br>
 */
public class BinarySearchStandard {
    int search(int aim, int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        while (start <= end) {
            int medium = (start + end) / 2;
            if (aim == ints[medium]) {
                return  medium;
            }
            else if (aim < ints[medium]) {
                end = medium - 1;
            }
            else {
                start = medium + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchStandard test = new BinarySearchStandard();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = 2 * i + 1;
        }
        int position = test.search(19, ints);
        System.out.println(position);
    }

}

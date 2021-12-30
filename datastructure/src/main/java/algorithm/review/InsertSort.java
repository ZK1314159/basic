package main.java.algorithm.review;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/8 20:45 <br>
 */
public class InsertSort {

    int[] insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int tmp = ints[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (ints[j] > tmp) {
                    ints[j + 1] = ints[j];
                }
                else {
                    //当数组左边第一个元素也满足ints[j] > tmp时，ints[j + 1] = tmp这段代码得不到执行
                    break;
                }
            }
            ints[j + 1] = tmp;
        }
        return ints;
    }

    public static void main(String[] args) {
        InsertSort test = new InsertSort();
        int[] ints = {1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        //int[] ints = {9, 3, 8, 4, 7, 5, 9, 2, 6, 5, 3};
        //int[] ints = {9, 7};

        int[] result = test.insertSort(ints);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

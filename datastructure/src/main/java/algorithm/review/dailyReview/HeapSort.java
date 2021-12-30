package main.java.algorithm.review.dailyReview;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/7 21:01 <br>
 */
public class HeapSort {

    void filterDown(int father, int end, int[] array) {
        int tmp = array[father];
        while (father * 2 + 1 <= end) {
            int son = father * 2 + 1;
            if (son + 1 <= end && array[son] < array[son + 1]) {
                son++;
            }
            if (tmp < array[son]) {
                array[father] = array[son];
                father = son;
            } else {
                break;
            }
        }
        array[father] = tmp;
    }

    void sort(int[] array) {
        //build main.java.heap
        for (int i = (array.length - 1 - 2) / 2; i >= 0; i--) {
            filterDown(i, array.length - 1, array);
        }

        //main.java.sort
        for (int i = array.length - 1; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            filterDown(0, i - 1, array);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = {9, 3, 4, 6, 7, 2, 3, 6, 34, 13, 32, 67, 99, 12, 24,
                1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 7, 9, 5, 2, 3};
        heapSort.sort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

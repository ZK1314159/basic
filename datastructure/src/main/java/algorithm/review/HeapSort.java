package main.java.algorithm.review;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/12 10:20 <br>
 */
public class HeapSort {
    void filterDown(int[] ints, int i, int size) {
        int son;
        int tmp = ints[i];
        while(i * 2 + 1 < size) {
            son = i * 2 + 1;
            if (son + 1 < size && ints[son] < ints[son + 1]) {
                son++;
            }
            if (tmp < ints[son]) {
                ints[i] = ints[son];
                i = son;
            }
            else {
                break;
            }
        }
        ints[i] = tmp;
    }

    void sort(int[] ints) {
        for (int i = (ints.length - 1) / 2 - 1; i >= 0; i--) {
            filterDown(ints, i, ints.length);
        }
        for (int i = ints.length - 1; i > 0; i--) {
            int tmp = ints[0];
            ints[0] = ints[i];
            ints[i] = tmp;
            filterDown(ints, 0, i);
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

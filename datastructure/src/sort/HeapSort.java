package sort;

import java.util.Arrays;

/**
 * 构建堆的方式不是将一个个元素添加到堆中，而是从后往前的下沉操作
 * 下沉操作也写得比较精炼
 * @param <T>
 */
public class HeapSort<T extends Comparable<? super T>> {
    private void filterDown(T[] arr, int i, int size) {
        int son;
        T tmp = arr[i];
        while (i * 2 + 1 < size) {
            son = i * 2 + 1;
            if (son + 1 < size && arr[son].compareTo(arr[son + 1]) < 0) {
                son++;
            }
            if (tmp.compareTo(arr[son]) < 0) {
                arr[i] = arr[son];
                i = son;
            }
            else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public void sort(T[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            filterDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            T tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            filterDown(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        HeapSort<Integer> test = new HeapSort<>();
        Integer[] arr = {9, 19, 77, 12, 18, 14, 37, 53, 36, 26, 71, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        Integer[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        test.sort(arr);
        for (Integer i : copy) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
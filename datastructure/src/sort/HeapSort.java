package sort;

import java.util.Arrays;

/**
 * Description：标准的堆排序，没有使用泛型
 * 出现的bug:
 * 1、下滤的过程中将arr[father]和arr[son]作比较，实际应该是将tmp和arr[son]作比较
 * 堆排序整体上细节非常多，写出来是有难度的
 * <br>
 * CreateDate：2021/10/22 16:28 <br>
 */
public class HeapSort {

    private void sort(int[] arr) {
        buildHeap(arr);
        coreSort(arr);
    }

    private void buildHeap(int[] arr) {
        // 下滤操作可以建立一个堆：对于任何一个节点，如果它的2个子节点都是标准的二叉堆，
        // 那么对这个节点进行下滤操作后，会形成一个新的标准的二叉堆
        // 有相当多的节点没有子节点，不需要进行下滤操作
        // 确定边界值比较麻烦，具体的方法是带入表达式，然后考虑奇数和偶数两种场景
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            downFilter(arr, i, arr.length - 1);
        }
    }

    private void coreSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            downFilter(arr, 0, i - 1);
        }
    }

    private void downFilter(int[] arr, int father, int boundary) {
        int tmp = arr[father];
        int son;
        while (father * 2 + 1 <= boundary) {
            son = father * 2 + 1;
            if (son + 1 <= boundary && arr[son + 1] > arr[son]) {
                son++;
            }
            if (tmp < arr[son]) {
                arr[father] = arr[son];
                father = son;
            } else {
                break;
            }
        }
        arr[father] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {9, 19, 77, 12, 18, 14, 37, 53, 36, 26, 71, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        heapSort.sort(arr);
        for (Integer i : copy) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

}

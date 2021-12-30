package sort;

import java.util.Arrays;

/**
 * Description：不用泛型的快排
 * <br>
 * CreateDate：2021/10/26 10:28 <br>
 */
public class QuickSortWithoutGeneric extends Sort {

    public void sort(int[] arr) {
        coreSort(arr, 0, arr.length - 1);
    }

    private void coreSort(int[] arr, int left, int right) {
        if (right - left <= 10) {
            insertSort(arr, left, right);
            return;
        }
        threeValue(arr, left, right);
        int leftPoint = left;
        int rightPoint = right - 1;
        int tmp = arr[right - 1];
        while (true) {
            while (arr[++leftPoint] < tmp) {}
            while (arr[--rightPoint] > tmp) {}
            if (leftPoint >= rightPoint) {
                break;
            }
            exchange(arr, leftPoint, rightPoint);
        }
        exchange(arr, leftPoint, right - 1);
        coreSort(arr, left, leftPoint - 1);
        coreSort(arr, leftPoint + 1, right);
    }
    
    private void insertSort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            int j;
            int tmp = arr[i];
            for (j = i; j >= 1; j--) {
                if (arr[j - 1] > tmp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = tmp;
        }
    }

    private void threeValue(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            exchange(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            exchange(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            exchange(arr, mid, right);
        }
        exchange(arr, mid, right - 1);
    }

    private void exchange(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new QuickSortWithoutGeneric();
        int[] array = {9, 9, 7, 7, 8, 4, 7, 3, 6, 6, 1, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        int[] copy = Arrays.copyOf(array, array.length);
        sort.sort(array);
        Arrays.sort(copy);
        sort.print(copy);
        sort.print(array);
    }
    
}

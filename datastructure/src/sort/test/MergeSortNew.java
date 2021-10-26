package sort.test;

import sort.Sort;

import java.util.Arrays;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/20 14:21 <br>
 */
public class MergeSortNew extends Sort {

    @Override
    public void sort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        int[] sortedArray = coreSort(start, end, array);
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = sortedArray[i];
        }
    }

    private int[] coreSort(int start, int end, int[] array) {
        if (end - start < 5) {
            return insertSort(start, end, array);
        }
        int medium = (start + end) / 2;
        int[] left = coreSort(start, medium, array);
        int[] right = coreSort(medium + 1, end, array);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, k = 0; i <= left.length - 1 && j <= right.length - 1;) {
            if (left[i] > right[j]) {
                result[k] = right[j];
                j++;
                k++;
                if (j == right.length ) {
                    for (int l = i; l <= left.length - 1; l++, k++) {
                        result[k] = left[l];
                    }
                }
            } else {
                result[k] = left[i];
                i++;
                k++;
                if (i == left.length) {
                    for (int m = j; m <= right.length - 1; m++, k++) {
                        result[k] = right[m];
                    }
                }
            }
        }
        return result;
    }

    private int[] insertSort(int start, int end, int[] array) {
        int[] result = Arrays.copyOfRange(array, start, end + 1);
        if (result.length == 0 || result.length == 1) {
            return result;
        }
        for (int i = 1; i <= result.length - 1; i++) {
            int tmp = result[i];
            int j;
            for (j = i; j >= 1 && result[j - 1] > tmp; j--) {
                result[j] = result[j - 1];
            }
            result[j] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSortNew mergeSortNew = new MergeSortNew();
        int[] array = {9, 9, 7, 7, 8, 4, 7, 3, 6, 6, 1, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        int[] copy = Arrays.copyOf(array, array.length);
        mergeSortNew.sort(array);
        Arrays.sort(copy);
        mergeSortNew.print(copy);
        mergeSortNew.print(array);
    }

}

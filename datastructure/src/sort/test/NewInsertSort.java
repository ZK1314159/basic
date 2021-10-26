package sort.test;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/19 23:03 <br>
 */
public class NewInsertSort {

    private void sort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = 1; i <= array.length - 1; i++) {
            int j = i;
            int tmp = array[j];
            while (j >= 1 && array[j - 1] > tmp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        NewInsertSort newInsertSort = new NewInsertSort();
        int[] array = {9, 9, 7, 7, 8, 4, 7, 3, 6, 6, 1, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19,
            0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        newInsertSort.sort(array);
    }

}

package sort;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/19 22:43 <br>
 */
public class BinarySearch {

    private int search(int target, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int medium = (start + end) / 2;
            if (array[medium] == target) {
                return medium;
            }
            if (array[medium] > target) {
                end = medium - 1;
                continue;
            }
            start = medium + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 4, 6, 7, 11, 16, 19, 23, 26, 28, 34, 38, 39, 39, 39, 41, 42, 45,
            47, 51, 52, 52, 53, 53, 53, 56, 57, 58, 60, 62, 64, 67};
        int position = binarySearch.search(39, array);
    }

}

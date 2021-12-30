package main.java.algorithm.review.dailyReview;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/22 21:05 <br>
 */
public class QuickSortTest {

    void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int j;
            int tmp = ints[i];
            for (j = i - 1; j >= 0; j--) {
                if (ints[j] > tmp) {
                    ints[j + 1] = ints[j];
                }
                else {
                    break;
                }
            }
            ints[j + 1] = tmp;
        }
    }

    void threeMedium(int[] ints, int left, int right) {
        int medium = (left + right) / 2;
        if (ints[left] > ints[medium]) {
            int tmp = ints[left];
            ints[left] = ints[medium];
            ints[medium] = tmp;
        }
        if (ints[left] > ints[right]) {
            int tmp = ints[left];
            ints[left] = ints[right];
            ints[right] = tmp;
        }
        if (ints[medium] > ints[right]) {
            int tmp = ints[medium];
            ints[medium] = ints[right];
            ints[right] = tmp;
        }
        int tmp = ints[medium];
        ints[medium] = ints[right - 1];
        ints[right - 1] = tmp;
    }


    void quickSort(int[] ints) {
        core(ints, 0, ints.length - 1);
    }

    void core(int[] ints, int left, int right) {
        if (right - left < 10) {
            insertSort(ints);
            return;
        }
        threeMedium(ints, left, right);
        int leftPoint = left;
        int rightPoint = right - 1;
        int medium = ints[right - 1];
        while (true) {
            while (ints[leftPoint++] <= medium) {}
            while (ints[rightPoint--] >= medium) {}
            if (leftPoint < rightPoint) {
                int tmp = ints[leftPoint];
                ints[leftPoint] = ints[rightPoint];
                ints[rightPoint] = tmp;
            } else {
                int tmp = ints[leftPoint];
                ints[leftPoint] = ints[right - 1];
                ints[right - 1] = tmp;
                break;
            }
        }
        core(ints, left, leftPoint - 1);
        core(ints, leftPoint + 1, right);
    }

    public static void main(String[] args) {
        QuickSortTest quickSortTest = new QuickSortTest();
        int[] ints = {9, 1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 45, 36, 85, 96, 23, 85, 68};
        quickSortTest.quickSort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

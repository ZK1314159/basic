package algorithm.review;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/11 14:43 <br>
 */
public class QuickSort {
    void insertSort(int[] ints, int left, int right) {
        for(int i = left + 1; i <= right; i++) {
            int tmp = ints[i];
            int j;
            for (j = i - 1; j >= left; j--) {
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

    void sort(int[] ints) {
        sort(ints, 0, ints.length - 1);
    }

    void sort(int[] ints, int left, int right) {
        if (right - left <= 5) {
            insertSort(ints, left, right);
            return;
        }
        handleMedium(ints, left, right);
        int leftPoint = left;
        int rightPoint = right - 1;
        int tmp = ints[right - 1];
        while (true) {
            while(ints[++leftPoint] < tmp) {}
            while(ints[--rightPoint] > tmp) {}
            if (leftPoint >= rightPoint) {
                break;
            }
            int tmp2 = ints[leftPoint];
            ints[leftPoint] = ints[rightPoint];
            ints[rightPoint] = tmp2;
        }
        int tmp2 = ints[leftPoint];
        ints[leftPoint] = ints[right - 1];
        ints[right - 1] = tmp2;
        sort(ints, left, leftPoint - 1);
        sort(ints, leftPoint + 1, right);
    }

    void handleMedium(int[] ints, int left, int right) {
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

    public static void main(String[] args) {
        QuickSort test = new QuickSort();
        //int[] ints = {1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 7, 9, 5, 2, 3};
        int[] ints = {9, 3, 4, 6, 7, 2, 3, 6, 34, 13, 32, 67, 99, 12, 24,
                      1, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 7, 9, 5, 2, 3};
        test.sort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

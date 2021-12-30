package main.java.historry.exam2020.tonghuashun;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/14 10:33 <br>
 */
public class MergeArray {
    int[] merge(int[] array1, int[] array2) {
        int[] tmp = new int[array1.length + array2.length];
        int k = 0;
        for (int i = 0, j = 0; i < array1.length && j < array2.length; ) {
            if (array1[i] <= array2[j]) {
                tmp[k] = array1[i];
                i++;
                k++;
                if (i == array1.length) {
                    for (int l = j; l < array2.length; l++) {
                        tmp[k] = array2[l];
                        k++;
                    }
                    break;
                }
            } else {
                tmp[k] = array2[j];
                j++;
                k++;
                if (j == array2.length) {
                    for (int m = i; m < array1.length; m++) {
                        tmp[k] = array2[m];
                        k++;
                    }
                    break;
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[] array1 = {1, 3, 5, 7, 8, 10};
        int[] array2 = {2, 3, 5, 8, 11};
        int[] result = mergeArray.merge(array1, array2);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}

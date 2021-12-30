package main.java.sort;

public class BubbleSort {
    private void sort(int[] arr) {
        int change = 1;
        for (int i = 0; i < arr.length - 1 && change != 0; i++) {
            change = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    change = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 3, 9, 4, 3, 6};
        BubbleSort bs = new BubbleSort();
        bs.sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}

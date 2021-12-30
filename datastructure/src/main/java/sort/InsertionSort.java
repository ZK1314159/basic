package sort;

public class InsertionSort<T extends Comparable<? super T>> {
    private void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            T tmp = arr[i];
            for (j = i; j > 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] ins = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        is.sort(ins);
        for (Integer i : ins) {
            System.out.print(i + " ");
        }
    }
}

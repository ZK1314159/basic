package main.java.sort;

public class ShellSort<T extends Comparable<? super T>> {
    private void sort(T[] a) {
        for (int i = 3; i > 0; i--) {
            int d = (1 << i) - 1;
            for (int j = d; j < a.length; j++) {
                int k;
                T tmp = a[j];
                for (k = j; k >= d && a[k].compareTo(a[k - d]) < 0; k -= d) {
                    a[k] = a[k - d];
                }
                a[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> is = new ShellSort<>();
        Integer[] ins = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        is.sort(ins);
        for (Integer i : ins) {
            System.out.print(i + " ");
        }
    }
}

package main.java.sort;

public class MergeSort<T extends Comparable<? super T>> {
    //@SuppressWarnings("unchecked")
    private void sort(T[] ins) {
        T[] tmp = (T[]) new Comparable[ins.length];
        sort(ins, tmp, 0, ins.length - 1);
    }

    private void sort(T[] ins, T[] tmp, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(ins, tmp, left, mid);
        sort(ins, tmp, mid + 1, right);
        merge(ins, tmp, left, right);
    }

    private void merge(T[] ins, T[] tmp, int leftPoint, int rightPoint) {
        int mid = (leftPoint + rightPoint) / 2;
        int right = mid + 1;
        int left = leftPoint;
        int index = leftPoint;
        while (left <= mid && right <= rightPoint) {
            if (ins[left].compareTo(ins[right]) < 0) {
                tmp[index++] = ins[left++];
            }
            else {
                tmp[index++] = ins[right++];
            }
        }
        if (left > mid) {
            for (int i = right; i <= rightPoint; i++) {
                tmp[index++] = ins[right++];
            }
        }
        else {
            for (int i = left; i <= mid; i++) {
                tmp[index++] = ins[left++];
            }
        }
        System.arraycopy(tmp, leftPoint, ins, leftPoint, rightPoint - leftPoint + 1);
    }

    public static void main(String[] args) {
        MergeSort<Integer> is = new MergeSort<>();
        Integer[] ins = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        is.sort(ins);
            for (Integer i : ins) {
            System.out.print(i + " ");
        }
    }
}

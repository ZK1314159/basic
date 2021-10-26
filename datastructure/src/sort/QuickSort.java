package sort;

public class QuickSort<T extends Comparable<? super T>> {
    private void insertSort(T[] ins, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j;
            T tmp = ins[i];
            for (j = i; j > 0; j--) {
                if (ins[j - 1].compareTo(tmp) > 0) {
                    ins[j] = ins[j - 1];
                }
                else {
                    break;
                }
            }
            ins[j] = tmp;
        }
    }

    private void threeValue(T[] ins, int left, int right) {
        int mid = (left + right) / 2;
        if (ins[left].compareTo(ins[mid]) > 0) {
            T tmp = ins[left];
            ins[left] = ins[mid];
            ins[mid] = tmp;
        }
        if (ins[mid].compareTo(ins[right]) > 0) {
            T tmp = ins[mid];
            ins[mid] = ins[right];
            ins[right] = tmp;
        }
        if (ins[left].compareTo(ins[mid]) > 0) {
            T tmp = ins[left];
            ins[left] = ins[mid];
            ins[mid] = tmp;
        }
        T tmp = ins[mid];
        ins[mid] = ins[right - 1];
        ins[right - 1] = tmp;
    }

    private void sort(T[] ins, int leftPoint, int rightPoint) {
        if (rightPoint - leftPoint <= 4) {
            insertSort(ins, leftPoint, rightPoint);
            return;
        }
        threeValue(ins, leftPoint, rightPoint);
        T tmp = ins[rightPoint - 1];
        int left = leftPoint;
        int right = rightPoint - 1;
        while (true) {
            while (ins[++left].compareTo(tmp) < 0) {}
            while (ins[--right].compareTo(tmp) > 0) {}
            if (left >= right) {
                break;
            }
            T tmp2 = ins[left];
            ins[left] = ins[right];
            ins[right] = tmp2;
        }
        T tmp2 = ins[left];
        ins[left] = ins[rightPoint - 1];
        ins[rightPoint - 1] = tmp2;
        sort(ins, leftPoint, left - 1);
        sort(ins, left + 1, rightPoint);
    }

    private void sort(T[] ins) {
        sort(ins, 0, ins.length - 1);
    }

    public static void main(String[] args) {
        QuickSort<Integer> test = new QuickSort<>();
        Integer[] ins = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        test.sort(ins);
        for (Integer i : ins) {
            System.out.print(i + " ");
        }
    }
}

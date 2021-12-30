package main.java.heap;

public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DefaultSize = 20;
    private T[] heap;
    private int size;

    public BinaryHeap() {
        this(DefaultSize);
    }

    public BinaryHeap(int size) {
        heap = (T[]) new Comparable[size + 1];
    }

    private void insert(T t) {
        size++;
        int father = size;
        for (heap[0] = t; t.compareTo(heap[father / 2]) < 0; father = father / 2) {
            heap[father] = heap[father / 2];
        }
        heap[father] = t;
    }

    private void deleteMin() {
        heap[1] = heap[size--];
        downPut(1);
    }

    private void downPut(int i) {
        int child;
        T tmp = heap[i];
        for (; i * 2 <= size; i = child) {
            child = i * 2;
            if (child != size && heap[child].compareTo(heap[child + 1]) > 0) {
                child++;
            }
            if (tmp.compareTo(heap[child]) > 0) {
                heap[i] = heap[child];
            } else {
                break;
            }
        }
        heap[i] = tmp;
    }

    private void print() {
        //System.out.println(size);
        int count = 1;
        int num = 20;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
        for (int i = 1; i < size + 1; i++) {
            System.out.print(heap[i] + ", ");
            if (i != (1 << count) - 1) {
                continue;
            }
            System.out.print("\n");
            for (int j = 0; j < num - (1 << count) * 3 / 2; j++) {
                System.out.print(" ");
            }

            count++;
        }
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> test = new BinaryHeap<>();
        test.insert(1);
        test.insert(3);
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(11);
        test.insert(13);
        test.insert(13);
        test.insert(13);
        test.insert(2);
        test.insert(13);
        test.insert(4);
        test.insert(13);
        test.insert(10);
        test.insert(8);
        test.insert(8);
        test.deleteMin();
        test.print();
    }
}

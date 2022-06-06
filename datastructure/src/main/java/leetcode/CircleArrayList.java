package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/6 17:16 <br>
 */
public class CircleArrayList {

    private int[] elements;

    private int size;

    private int end = -1;

    private int initialCapacity;

    public CircleArrayList(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        elements = new int[initialCapacity];
    }

    void add(int i) {
        if (end == initialCapacity - 1) {
            end = 0;
        } else {
            end++;
        }
        elements[end] = i;
        if (size < initialCapacity) {
            size++;
        }
    }

    int get(int position) {
        if (size < initialCapacity) {
            if (position > size - 1) {
                throw new IndexOutOfBoundsException();
            }
            return elements[position];
        } else {
            int distance = initialCapacity - 1 - position;
            if (distance > end) {
                return elements[end + initialCapacity - distance];
            } else {
                return elements[end - distance];
            }
        }
    }

    void clear() {
        end = -1;
        size = 0;
    }

    public static void main(String[] args) {
        CircleArrayList circleArrayList = new CircleArrayList(10);
        for (int i = 0; i < 5; i++) {
            circleArrayList.add(i);
        }
        // 6
        int tmp = circleArrayList.get(3);
        circleArrayList.clear();
        for (int i = 0; i < 25; i++) {
            circleArrayList.add(i);
        }
        // 20
        int newTmp = circleArrayList.get(5);
    }

}

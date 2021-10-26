package sort;

import java.util.Arrays;

/**
 * Description：自己写的堆排序
 * bug记录：
 * bug1: 构建堆的过程中比较对象不是tmp
 * bug2：排序的过程中，没有将son的值和tmp比较
 * 知识：break一般只会跳出内层循环，不会跳出外层循环
 * <br>
 * CreateDate：2021/10/20 20:15 <br>
 */
public class HeapSortOrigin extends Sort {

    @Override
    public void sort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        buildHeap(array);
        coreSort(array);
    }

    private void buildHeap(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            upFilter(array, i);
        }
    }

    private void coreSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            int tmp = array[i];
            array[i] = array[0];
            int father = 0;
            int son;
            int boundary = i - 1;
            while (father <= boundary) {
                int leftSon = father * 2 + 1;
                int rightSon = father * 2 + 2;
                if (rightSon > boundary) {
                    if (leftSon <= boundary) {
                        son = leftSon;
                    } else {
                        break;
                    }
                } else {
                    if (array[rightSon] >= array[leftSon]) {
                        son = rightSon;
                    } else {
                        son = leftSon;
                    }
                }
                if (array[son] > tmp) {
                    array[father] = array[son];
                    father = son;
                } else {
                    break;
                }
            }
            array[father] = tmp;
        }
    }

    private void upFilter(int[] array, int son) {
        int tmp = array[son];
        int father = getFather(son);
        while (father >= 0 && array[father] < tmp) {
            array[son] = array[father];
            son = father;
            father = getFather(father);
        }
        array[son] = tmp;
    }

    private int getFather(int position) {
        int resident = position % 2;
        int father;
        if (resident == 0) {
            father = position / 2 - 1;
        } else {
            father = position / 2;
        }
        return father;
    }

    public static void main(String[] args) {
        Sort sort = new HeapSortOrigin();
        int[] array = {9, 19, 77, 12, 18, 14, 37, 53, 36, 26, 71, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        int[] copy = Arrays.copyOf(array, array.length);
        sort.sort(array);
        Arrays.sort(copy);
        sort.print(copy);
        sort.print(array);
    }

}

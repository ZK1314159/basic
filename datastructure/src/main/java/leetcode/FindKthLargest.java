package leetcode;

import java.util.Arrays;

import sort.Sort;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/27 22:38 <br>
 */
public class FindKthLargest extends Sort {

    public void sort(int[] nums) {

    }

    public int findKthLargest(int[] nums, int k) {
        return coreFind(nums, nums.length - k , 0, nums.length - 1);
    }

    private int coreFind(int[] nums, int k, int left, int right) {
        if (right - left <= 10) {
            insertSort(nums, left, right);
            return nums[k];
        }
        threeValue(nums, left, right);
        int leftPoint = left;
        int rightPoint = right - 1;
        int tmp = nums[rightPoint];
        while (true) {
            while(nums[++leftPoint] < tmp) {}
            while(nums[--rightPoint] > tmp) {}
            if (leftPoint >= rightPoint) {
                break;
            }
            exchange(nums, leftPoint, rightPoint);
        }
        exchange(nums, leftPoint, right - 1);
        if (leftPoint == k) {
            return nums[leftPoint];
        }
        if (leftPoint < k) {
            return coreFind(nums, k, leftPoint + 1, right);
        }
        return coreFind(nums, k, left, leftPoint - 1);
    }

    private void threeValue(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[left] > nums[mid]) {
            exchange(nums, left, mid);
        }
        if (nums[left] > nums[right]) {
            exchange(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            exchange(nums, mid, right);
        }
        exchange(nums, mid, right - 1);
    }

    private void exchange(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void insertSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            int j;
            int tmp = nums[i];
            for (j = i; j >= 1; j--) {
                if (nums[j - 1] > tmp) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] array = {9, 9, 7, 7, 8, 4, 7, 3, 6, 6, 1, 3, 1, 4, 1, 5, 9, 2, 6, 5,
                2, 5, 3, 5, 4, 9, 6, 10, 11, 19, 63, 78, 66, 34, 90, 55, 25, 10, 92,
                0, -1, 34, 22, 17, 14, 9, 66, 96, 86, 22, 47, 74, 48};
        int[] copy = Arrays.copyOf(array, array.length);
        int length = copy.length;
        System.out.println(length);
        int result = findKthLargest.findKthLargest(array, 5);
        System.out.println(result);
        Arrays.sort(copy);
        findKthLargest.print(copy);
    }

}

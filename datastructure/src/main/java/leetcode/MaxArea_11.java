package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/3 11:56 <br>
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}

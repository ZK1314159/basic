package leetcode.combination;

import java.util.Arrays;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 20:59 <br>
 */
public class TwoDimensionArray_Cut {

    public boolean haveCombination(int[] array, int target) {
        Arrays.sort(array);
        boolean[][] dp = new boolean[array.length + 1][target + 1];
        for (int i = 0; i <= array.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (array[i - 1] <= j) {
                    if (dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - array[i - 1]];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j == target && dp[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDimensionArray_Cut combination = new TwoDimensionArray_Cut();
        int[] array = new int[] {1, 3, 6, 9, 23, 45, 56};
        int target = 38;
        boolean answer = combination.haveCombination(array, target);
    }

}

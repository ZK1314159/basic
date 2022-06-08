package leetcode.combination;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 20:59 <br>
 */
public class OneDimensionArray_Cut {

    public boolean haveCombination(int[] array, int target) {
        // 优化思路1：遍历array,设置所有dp[i]=true,循环中先判断dp(i)是否为true，但
        // 需要调换内外层的循环顺序
        // 优化思路2：遍历array,求和，若和小于target，返回false.
        // 排序，最小元素之前的dp[i]都为false
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = target; j >= 1; j--) {
                if (array[i] <= j) {
                    if (! dp[j]) {
                        dp[j] = dp[j - array[i]];
                        if (j == target && dp[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OneDimensionArray_Cut combination = new OneDimensionArray_Cut();
        int[] array = new int[] {1, 3, 6, 9, 23, 45, 56};
        int target = 38;
        boolean answer = combination.haveCombination(array, target);
    }

}

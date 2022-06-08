package leetcode.combination;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 20:59 <br>
 */
public class OneDimensionArray {

    public boolean haveCombination(int[] array, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = target; j >= 1; j--) {
                if (array[i] <= j) {
                    if (! dp[j]) {
                        dp[j] = dp[j - array[i]];
                    }
                }
                if (j == target && dp[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OneDimensionArray combination = new OneDimensionArray();
        int[] array = new int[] {1, 3, 6, 9, 23, 45, 56};
        int target = 38;
        boolean answer = combination.haveCombination(array, target);
    }

}

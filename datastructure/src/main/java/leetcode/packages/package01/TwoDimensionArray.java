package leetcode.packages.package01;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 15:46 <br>
 */
public class TwoDimensionArray {

    // dp(i, j) = max(dp(i - 1, j - w(i)) + w(i), dp(i - 1, j))
    public int maxValue(int[][] goods, int packageSize) {
        int number = goods.length;
        int[][] dp = new int[number + 1][packageSize + 1];
        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= packageSize; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int weight = goods[i - 1][0];
                int value = goods[i - 1][1];
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int candidate = dp[i - 1][j - weight] + value;
                    dp[i][j] = Math.max(dp[i - 1][j], candidate);
                }
            }
        }
        return dp[number][packageSize];
    }

    public static void main(String[] args) {
        int[][] goods = new int[][] {{1, 15}, {3, 20}, {4, 30}};
        int packageSize = 4;
        TwoDimensionArray test = new TwoDimensionArray();
        int answer = test.maxValue(goods, packageSize);
    }

}

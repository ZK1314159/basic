package leetcode.packages.fullpackage;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 17:08 <br>
 */
public class FullPackage {

    // 完全背包和01背包的递推公式是不同的
    // 对于dp(i, j) = max(dp(i, j - w(i)) + w(i), dp(i - 1, j))
    public int maxValue(int[][] goods, int packageSize) {
        int[] dp = new int[packageSize + 1];
        for (int i = 0; i < goods.length; i++) {
            for (int j = 1; j <= packageSize ; j++) {
                int weight = goods[i][0];
                int value = goods[i][1];
                if (weight <= j) {
                    int candidate = dp[j - weight] + value;
                    dp[j] = Math.max(dp[j], candidate);
                }
            }
        }
        return dp[packageSize];
    }

    public static void main(String[] args) {
        int[][] goods = new int[][] {{3, 50}, {4, 40}, {7, 140}};
        int packageSize = 9;
        FullPackage test = new FullPackage();
        int answer = test.maxValue(goods, packageSize);
    }

}

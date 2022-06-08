package leetcode.packages.fullpackage;

import leetcode.packages.package01.OneDimensionArray;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 17:08 <br>
 */
public class FullPackage {

    public int maxValue(int[][] goods, int packageSize) {
        int[] dp = new int[packageSize + 1];
        for (int i = 0; i <= packageSize; i++) {
            for (int j = 0; j < goods.length; j++) {
                int weight = goods[j][0];
                int value = goods[j][1];
                if (weight <= i) {
                    int candidate = dp[i - weight] + value;
                    dp[i] = Math.max(dp[i], candidate);
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

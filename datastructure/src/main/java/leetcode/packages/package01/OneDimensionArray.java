package leetcode.packages.package01;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/8 15:46 <br>
 */
public class OneDimensionArray {

    public int maxValue(int[][] goods, int packageSize) {
        int[] dp = new int[packageSize + 1];
        for (int i = 0; i < goods.length; i++) {
            for (int j = packageSize; j > 0; j--) {
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
        int[][] goods = new int[][] {{1, 15}, {3, 20}, {4, 30}};
        int packageSize = 4;
        OneDimensionArray test = new OneDimensionArray();
        int answer = test.maxValue(goods, packageSize);
    }

}

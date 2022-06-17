package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/13 21:45 <br>
 */

//1 <= prices.length <= 5000
//0 <= prices[i] <= 1000

public class MaxProfit_309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        // 持有股票
        dp[0][0] = - prices[0];
        // 不持有股票， 下一天不是冷冻期
        dp[0][1] = 0;
        // 不持有股票， 下一天是冷冻期
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,0,2};
        MaxProfit_309 test = new MaxProfit_309();
        int anser = test.maxProfit(prices);
    }

}

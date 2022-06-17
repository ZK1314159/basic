package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/13 21:45 <br>
 */

//1 <= prices.length <= 5000
//0 <= prices[i] <= 1000

public class MaxProfit_309_standard {

    public int maxProfit(int[] prices) {
        int[] dp = new int[3];
        // dp[0]持有股票
        dp[0] = - prices[0];
        // dp[1]不持有股票， 下一天不是冷冻期
        // dp[2]不持有股票， 下一天是冷冻期
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[2]);
            dp[2] = tmp + prices[i];
        }
        return Math.max(dp[1], dp[2]);
    }

    public static void main(String[] args) {
    }

}

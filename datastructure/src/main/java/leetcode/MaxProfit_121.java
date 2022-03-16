package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/16 19:33 <br>
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int max = 0;
        int last = 0;
        for (int i = 1; i < prices.length; i++) {
            last += prices[i] - prices[i - 1];
            if (prices[i] > prices[i - 1]) {
                max = Math.max(max, last);
            } else if (prices[i] < prices[i - 1]) {
                last = Math.max(0, last);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxProfit_121 test = new MaxProfit_121();
        int[] prices = new int[] {7,1,5,3,6,4};
        int answer = test.maxProfit(prices);
    }

}

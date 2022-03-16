package leetcode;

/**
 * Description：<br>
 * 19:18开始看题
 * 19:32 想到算法
 * 19:54 写完算法
 * 20:24 算法AC
 * 20:38 官方算法AC
 * CreateDate：2022/3/16 19:33 <br>
 */
public class MaxProfit_121_standard {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit_121_standard test = new MaxProfit_121_standard();
        int[] prices = new int[] {7,1,5,3,6,4};
        int answer = test.maxProfit(prices);
    }

}

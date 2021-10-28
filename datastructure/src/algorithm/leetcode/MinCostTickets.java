package algorithm.leetcode;

import java.util.Arrays;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/10/28 15:08 <br>
 */
public class MinCostTickets {

    public int mincostTickets(int[] days, int[] costs) {

        // 遵循基本的动态规划思想
        // cost(m, n) = cost(m, i) + cost(i + 1, n), m < i <= n
        // cost(m, m) = costs[0]
        // 特殊之处在于m - n <= 29的时候要考虑一张票是否可行； m - n <= 6要考虑一张票是否可行
        // 账本的数量至多为（days.length)^2
        // 最优的方式一定是该数组的某种分割，所以可以用动态规划
        // 最优结果是可以通过子问题的组合得到
        // 最优购买策略中，购买时间区间不会重叠
        // 需要考虑7日票比1日票更便宜等极端情况, 感觉这题的设定有毒

        // 需要考虑days仅有一天的边界
        int[] costCopy = Arrays.copyOf(costs, costs.length);
        Arrays.sort(costCopy);
        int minCost = costCopy[0];
        if (days.length == 1) {
            return minCost;
        }

        int oneDayCost = costs[0];
        int sevenDayCost = costs[1];
        int thirtyDayCost = costs[2];

        // 初始化账本，单日购买的最低成本是costs中的最小值
        int[][] cost = new int[days.length][days.length];
        for (int i = 0; i <= days.length - 1; i++) {
            cost[i][i] = minCost;
        }

        for (int step = 2; step <= days.length; step++) {
            for (int left = 0; left <= days.length - step; left++) {
                int right = left + step - 1;
                cost[left][right] = Integer.MAX_VALUE;
                for (int start = left; start <= right - 1; start++) {
                    if (cost[left][start] + cost[start + 1][right] < cost[left][right]) {
                        cost[left][right] = cost[left][start] + cost[start + 1][right];
                    }
                }
                if (days[right] - days[left] >= 30) {
                    continue;
                }
                if (days[right] - days[left] >= 7) {
                    if (cost[left][right] > thirtyDayCost) {
                        cost[left][right] = thirtyDayCost;
                    }
                    continue;
                }
                int minerCost = Math.min(sevenDayCost, thirtyDayCost);
                if (cost[left][right] > minerCost) {
                    cost[left][right] = minerCost;
                }
            }
        }
        return cost[0][days.length - 1];
    }

    public static void main(String[] args) {
        MinCostTickets minCostTickets = new MinCostTickets();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7,2,15};
        int result = minCostTickets.mincostTickets(days, costs);
        System.out.println(result);
    }

}

package algorithm.leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/1/17 16:03 <br>
 */
public class AllocateSoup {

    public double soupServings(int n) {

        // 起始状态（m, n）,结束状态（m == 0 || n == 0）
        // 状态转移方程：（m, n） + 分汤操作 = (m - a, n - b)
        // 可以计算dp（m == 0 || n == 0）的可能方式总数
        // 分别计算dp(m == 0 && n == 0), dp(m == 0 && n > 0), dp(m > 0 && n == 0)
        // 最后计算概率，概率计算就是古典概率
        // 账本的空间是N^2
        return 1L;
    }
}

package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/15 9:17 <br>
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int fn_2 = 1;
        int fn_1 = 2;
        int count = 2;
        while (count < n) {
            count++;
            int tmp = fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = tmp;
        }

        return fn_1;
    }

}

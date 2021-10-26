package algorithm.review.leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/20 21:15 <br>
 */
public class BranchTest {
    public int sqrt (int x) {
        // write code here
        long start = 1;
        long end = x;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long medium = (start + end) / 2;
        while (end >= start) {
            medium = (start + end) / 2;
            if (medium * medium == x) {
                return (int) medium;
            }
            else if (medium * medium < x) {
                start = medium + 1;
            }
            else {
                end = medium - 1;
            }
        }
        if (medium * medium  > x ) {
            return (int) medium - 1;
        }
        else {
            return (int) medium;
        }
    }

    public static void main(String[] args) {
        BranchTest test = new BranchTest();
        int result = test.sqrt(128864081);
        System.out.println(result);
        //38974
    }
}

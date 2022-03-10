package leetcode;

/**
 * Description：<br>
 * 17:57开始读题
 * 18:03 想到算法
 * 18:40 写完算法
 * 18:46 算法AC
 * 19:16 官方算法AC
 * CreateDate：2022/3/10 21:50 <br>
 */
public class SortColors_75_standard {

    public void sortColors(int[] nums) {
        int redRight = -1;
        int whiteRight = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redRight++;
                nums[redRight] = 0;
                if (whiteRight > -1) {
                    whiteRight++;
                    nums[whiteRight] = 1;
                    if (whiteRight != i) {
                        nums[i] = 2;
                    }
                } else if (redRight != i) {
                    nums[i] = 2;
                }
            } else if (nums[i] == 1) {
                if (whiteRight > -1) {
                    whiteRight++;
                } else {
                    whiteRight = redRight + 1;
                }
                nums[whiteRight] = 1;
                if (whiteRight != i) {
                    nums[i] = 2;
                }
            }
        }
    }

}

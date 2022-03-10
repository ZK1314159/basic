package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/10 18:03 <br>
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {
        int redRight = -1;
        int whiteRight = -1;
        int blueRight = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (blueRight > -1) {
                    blueRight++;
                    nums[blueRight] = 2;
                }
                if (whiteRight > -1) {
                    whiteRight++;
                    nums[whiteRight] = 1;
                }
                redRight++;
                nums[redRight] = 0;
            } else if (nums[i] == 1) {
                if (blueRight > -1) {
                    blueRight++;
                    nums[blueRight] = 2;
                }
                if (whiteRight == -1) {
                    whiteRight = redRight + 1;
                } else {
                    whiteRight++;
                }
                nums[whiteRight] = 1;
            } else {
                if (blueRight == -1) {
                    if (whiteRight == -1) {
                        blueRight = redRight + 1;
                    } else {
                        blueRight = whiteRight + 1;
                    }
                } else {
                    blueRight++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        SortColors_75 test = new SortColors_75();
        test.sortColors(nums);
    }

}

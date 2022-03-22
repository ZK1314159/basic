package leetcode;

/**
 * Description：<br>
 * 16:38开始读题
 * 16:54  了解官方算法
 * 16:59  写完官方算法
 * 16:59  官方算法AC
 * CreateDate：2022/3/22 16:54 <br>
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int number : nums) {
            if (count == 0) {
                candidate = number;
                count++;
                continue;
            }
            if (candidate == number) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

}

package leetcode;

/**
 * Description：<br>
 * 8:46开始读题
 * 9:25 看懂题解
 * 9:28 完成编码
 * 9:31 编码AC
 * CreateDate：2022/4/15 9:26 <br>
 */
public class HammingDistance_461 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor > 0) {
            xor &= xor - 1;
            count++;
        }
        return count;
    }

}

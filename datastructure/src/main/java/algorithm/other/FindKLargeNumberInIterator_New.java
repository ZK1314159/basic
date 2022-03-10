package algorithm.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/10 13:08 <br>
 */
public class FindKLargeNumberInIterator_New {

    private List<Integer> list = new ArrayList<>();

    public int findKLarge(int n) {

        // 计算进行(3 * k + 1)迭代的最大次数
        int count = 1;
        int maxRightIterate = 0;
        int maxRight = 1;
        while (count < n) {
            maxRightIterate++;
            count += count + 1;
            maxRight = maxRight * 3 + 1;
        }

        // 计算总迭代的最大次数，等于进行(2 * k + 1)迭代的最大次数
        // 理论推导可以得到迭代次数上限:
        // int maxIterate2 = (int) Math.ceil(Math.log(Math.pow(3, Math.log(n + 1) / Math.log(2)) + 1) / Math.log(2) - 2);
        int maxIterate = 0;
        int leftMax = 1;
        while (leftMax < maxRight) {
            maxIterate++;
            leftMax = leftMax * 2 + 1;
        }
        maxIterate--;

        // 通过迭代穷举可能产生的数
        list.add(1);
        // 理论迭代总时间复杂度为2^(log(3)*log(n)), 因为各种剪枝，实际应该接近于n
        recursive(1, 0, 0, maxIterate, maxRightIterate, leftMax);
        // 寻找第K大元素, 理论复杂度是n, 这里直接用系统排序, n*log(n)
        list.sort(Comparator.comparingInt(v -> v));

        return list.get(n - 1);
    }

    public void recursive(int last, int left, int right, int maxIterate, int maxRightIterate, int leftMax) {
        int newLeft = left;
        int newLast = last;

        left++;
        if (left + right <= maxIterate) {
            last = last * 2 + 1;
            if (last < leftMax) {
                list.add(last);
                recursive(last, left, right, maxIterate, maxRightIterate, leftMax);
            }
        }

        right++;
        if (right <= maxRightIterate && newLeft + right <= maxIterate) {
            newLast = newLast * 3 + 1;
            if (newLast < leftMax) {
                list.add(newLast);
                recursive(newLast, newLeft, right, maxIterate, maxRightIterate, leftMax);
            }
        }
    }

    public static void main(String[] args) {
        FindKLargeNumberInIterator_New findKLargeNumberInIterator = new FindKLargeNumberInIterator_New();
        int result = findKLargeNumberInIterator.findKLarge(10000);
    }

}

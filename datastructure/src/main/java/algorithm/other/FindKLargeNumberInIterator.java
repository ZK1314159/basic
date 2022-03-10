package algorithm.other;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/1 23:39 <br>
 */
public class FindKLargeNumberInIterator {

    private List<Integer> list = new LinkedList<>();

    public int findKLarge(int n) {
        // 处理特殊场景
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (n == 3) {
            return 4;
        }

        // 计算最大迭代次数
        int count = (int) Math.ceil(Math.log(Math.pow(3, Math.log(n + 1) / Math.log(2)) + 1) / Math.log(2) - 1);
//        int count2 = (int) Math.ceil(Math.log(n + 1) / Math.log(2) * Math.log(3) / Math.log(2));
        int start = 1;
        int max;
        list.add(start);
        // 推理过程：
        // 已知迭代会形成一个三角矩阵，矩阵从左到右递增，某一行最小值在最左，最大值在最右，从上到下单调递增
        // 最左侧元素的值是2^n - 1, 最右侧元素值是(3^n-1)/2
        // 已经第一行元素个数为1, 第n行元素个数为2^(n-1), 第n行以及以前的元素个数为2^n - 1
        // 现在寻找第m大的元素
        // 现在从最右侧寻找元素，假设是第n行，累积元素个数恰好等于m, 此时最右侧元素大小为(3^n-1)/2
        // 所以: n = log(m+1)
        // 当最右侧元素等于(3^n-1)/2时，对应的行号为n=log(m+1)*log(3)
        // 细节推理：倘若第n行，累积元素个数恰好等于m, 最右侧元素记为right.那么就有m个元素小于等于right.
        // 但是更高楼层也会有元素大于right.假设最左侧某个元素left恰好等于right.那么这个元素所在楼层
        // 以及以下的楼层包含了所有不大于right的数。
        // 综上，可以知道left所在的楼层以及以下的的楼层有m个元素不大于right,并且包含了不大于right的数，
        // 因此第m大的元素就在这些楼层之中
        // 因此对于第m大的元素，至多需要遍历的楼层数是n=log(m+1)*log(3)
        // 准确公式是n=log2(3^log2(m+1)+1)-1
        recursive(start, count);
        // 寻找第K大的元素, 理论上复杂度是n, 为了简化表示直接用系统排序方式n*log(n)
        list = list.stream().sorted().collect(Collectors.toList());
        int min = list.get(0);
        int newMax = list.get(list.size() - 1);
        max = list.get(n - 1);

        return max;
    }

    public void recursive(int start, int n) {
        if (n > 1) {
            int left = start * 2 + 1;
            int right = start * 3 + 1;
            list.add(left);
            list.add(right);
            n--;
            recursive(left, n);
            recursive(right, n);
        }
    }

//        // 基本数据结构，用于存储可能的候选集
//        // 用数组存储数对是合适的
//        // 数组3位数分别代表楼层，(3K+1)变换次数，变换后的实际值
//        PriorityQueue<int[]> candidate = new PriorityQueue<>(Comparator.comparingInt(v -> v[2]));
//        int[] specialCandidate = new int[2];
//        specialCandidate[0] = 1;
//        specialCandidate[1] = 3;
//        int count = 4;
//        int max = 4;
//
//        // 循环寻找第n大的值
//        while (count <= n) {
//            // 新的候选元素生成方式：特殊元素进行(2K+1)的变换, 其他候选集中的最小元素进行(2K+1) -> (3K+1)的变换
//            int next1 = specialCandidate[1] * 2 + 1;
//            int[] exact = candidate.peek();
//            // 假定数据范围在int范围内
//            int next2 = Integer.MAX_VALUE;
//            if (exact != null) {
//                next2 = ((exact[2] - 1) / 2) * 3 + 1;
//            }
//            if (next1 < next2) {
//                max = next1;
//                // 特殊候选集更新方式：向下进行(2K+1)的变换
//                specialCandidate[0]++;
//                specialCandidate[1] = next1;
//                // 候选集加入元素方式1：向下进行(2K+1)的变换，虽然是同一个值，但是会产生两种可能的变换方式
//                candidate.offer(new int[]{specialCandidate[0], 0, next1});
//            } else {
//                max = next2;
//                if (exact[0] - exact[1] == 1) {
//                    // 候选集删除元素方式：向右进行(2K+1) -> (3K+1)的变换到达极限
//                    candidate.poll();
//                } else {
//                    exact[1]++;
//                    exact[2] = next2;
//                    candidate.poll();
//                    // 候选集加入元素方式2：向右进行(2K+1) -> (3K+1)的变换
//                    candidate.offer(exact);
//                }
//            }
//            count++;
//        }

    public static void main(String[] args) {
        FindKLargeNumberInIterator findKLargeNumberInIterator = new FindKLargeNumberInIterator();
        // 52w
        // 最大可以算5000以内的
        int result = findKLargeNumberInIterator.findKLarge(5000);
    }
}

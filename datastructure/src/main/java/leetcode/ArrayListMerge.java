package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/1 15:56 <br>
 */
public class ArrayListMerge {
    
    public int[] merge(int[] left, int[] right) {
        if (left == null || left.length == 0) {
            return right;
        }
        if (right == null || right.length == 0) {
            return left;
        }
        int[] answer = new int[left.length + right.length];
        int first = 0;
        int second = 0;
        int pos = 0;
        while (first < left.length && second < right.length) {
            if (left[first] <= right[second]) {
                answer[pos] = left[first];
                first++;
            } else {
                answer[pos] = right[second];
                second++;
            }
            pos++;
        }
        if (first == left.length) {
            while (second < right.length) {
                answer[pos] = right[second];
                second++;
                pos++;
            }
        } else {
            while (first < left.length) {
                answer[pos] = left[first];
                first++;
                pos++;
            }
        }
        return answer;
    }
    
}

package leetcode;

/**
 * Description：<br>
 * 15:37 开始看题
 * 16:16 思考了解法，复杂度为o(mlogn),直接看官方解答，然后写算法，将算法优化到最佳
 * CreateDate：2022/6/4 16:04 <br>
 */

// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matrix[i][j] <= 109
// 每行的所有元素从左到右升序排列
// 每列的所有元素从上到下升序排列
// -109 <= target <= 109

public class SearchMatrix_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}

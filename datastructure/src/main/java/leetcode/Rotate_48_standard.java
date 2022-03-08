package leetcode;

/**
 * Description：<br>
 * <br>
 * 14:39 开始读题
 * 14:44 想好算法
 * 15:44 写完算法
 * 15:58 算法AC
 * 16:30 官方算法AC
 * CreateDate：2022/3/8 14:45 <br>
 */
public class Rotate_48_standard {

    /**
     * 下一个点的x坐标只会和前一个点的x或者y坐标之一相关，不可能和2个都相关
     * 定位方法是先判断和那个坐标相关，然后判断走势，最后确定常数项
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                int tmp = matrix[i][j];
                // 1
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                // 4
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                // 3
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                // 2
                matrix[j][matrix.length - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {

//        int[][] tmp = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{5,14,12,16}};
        int[][] tmp2 = new int[][] {{5,1,9},{2,4,8},{13,3,6},{5,14,12}};
        int length = tmp2.length;
        int i = tmp2[3][2];

        int[][] tmp3 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        Rotate_48_standard test = new Rotate_48_standard();
        test.rotate(tmp3);
    }

}

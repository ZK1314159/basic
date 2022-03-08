package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/8 14:45 <br>
 */
public class Rotate_48 {

    public void rotate(int[][] matrix) {
        recursive(0, matrix.length - 1, matrix);
    }

    void recursive(int layer, int length, int[][] matrix) {
        if (layer == (int) Math.ceil(matrix.length / 2.0)) {
            if (length > 0) {
                rotate(layer, length, matrix);
            } else {
                return;
            }
        }
        rotate(layer, length, matrix);
        layer++;
        length -= 2;
        recursive(layer, length, matrix);
    }

    void rotate(int layer, int length, int[][] matrix) {
        for (int i = 0; i < length; i++) {
            int tmp = matrix[layer][layer + i];
            // 1
            matrix[layer][layer + i] = matrix[matrix.length - 1 - layer - i][layer];
            // 4
            matrix[matrix.length - 1 - layer - i][layer] = matrix[matrix.length - 1 - layer][matrix.length - 1 - layer - i];
            // 3
            matrix[matrix.length - 1 - layer][matrix.length - 1 - layer - i] = matrix[layer + i][matrix.length - 1 - layer];
            // 2
            matrix[layer + i][matrix.length - 1 - layer] = tmp;
        }
    }

    public static void main(String[] args) {

//        int[][] tmp = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{5,14,12,16}};
        int[][] tmp2 = new int[][] {{5,1,9},{2,4,8},{13,3,6},{5,14,12}};
        int length = tmp2.length;
        int i = tmp2[3][2];

        int[][] tmp3 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        Rotate_48 test = new Rotate_48();
        test.rotate(tmp3);
    }

}

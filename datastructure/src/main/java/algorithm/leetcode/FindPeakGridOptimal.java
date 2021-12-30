package algorithm.leetcode;

import java.io.FileReader;
import java.io.IOException;

/**
 * Description：leetcode_1901
 * <br>
 * CreateDate：2021/11/4 20:12 <br>
 */
public class FindPeakGridOptimal {

    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midMax = findMaxPos(mat, mid);
            if (start == end) {
                return new int[]{mid, midMax};
            }
            int midValue = mat[mid][midMax];
            int midValueUp = mid == 0 ? -1 : mat[mid - 1][midMax];
            int midValueDown = mid == mat.length - 1 ? -1 : mat[mid + 1][midMax];
            if (midValue > midValueUp && midValue > midValueDown) {
                return new int[]{mid, midMax};
            }
            if (midValue < midValueUp) {
                end = mid - 1;
                continue;
            }
            if (midValue < midValueDown) {
                start = mid + 1;
            }
        }
        return null;
    }

    private int findMaxPos(int[][] mat, int line) {
        int pos = 0;
        int max = mat[line][0];
        for (int i = 1; i < mat[line].length; i++) {
            if (mat[line][i] > max) {
                max = mat[line][i];
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        try (FileReader fileReader = new FileReader("D:\\Software\\Work\\Data\\Idea\\Projects\\java\\datastructure" +
                "\\src\\data.txt")) {
            char[] bucket = new char[32];
            int hasRead;
            while ((hasRead = fileReader.read(bucket)) > 0) {
                String tmp = new String(bucket, 0, hasRead);
                data.append(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String finalData = data.toString();
        String[] lineData = finalData.split("},\\{");
        String[] secondData = lineData[0].split(",");
        int lineNumber = lineData.length;
        int secondNumber = secondData.length;
        int[][] mat = new int[lineNumber][secondNumber];
        for (int i = 0; i <= lineNumber - 1; i++) {
            String[] tmp = lineData[i].split(",");
            int[] intTmp = new int[tmp.length];
            for (int j = 0; j <= tmp.length - 1; j++) {
                intTmp[j] = Integer.parseInt(tmp[j]);
            }
            mat[i] = intTmp;
        }
        FindPeakGridOptimal findPeakGridOptimal = new FindPeakGridOptimal();
        int[] result = findPeakGridOptimal.findPeakGrid(mat);
    }

}

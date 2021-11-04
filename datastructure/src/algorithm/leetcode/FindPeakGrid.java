package algorithm.leetcode;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/11/3 17:19 <br>
 */
public class FindPeakGrid {

    private boolean[][] record;
    private int xLength;
    private int yLength;

    public int[] findPeakGrid(int[][] mat) {
        record = new boolean[mat.length][mat[0].length];
        xLength = mat[0].length;
        yLength = mat.length;
        return findPeak(mat, 0, 0);
    }

    public int[] findPeak(int[][] mat, int y, int x) {
        record[y][x] = true;
        TreeMap<Integer, int[]> map = new TreeMap<>();

        // 点(y,x)
        // 在4个方向上寻找更大的值，如果找到，将这些点中最大的点作为下一个迭代的点
        // 如果4个方向都没找到，则这个点是极值点，返回
        // 任何一个被搜索过点用账本记录下来，不重复搜索

        // 顺时针判断周围4个点
        // 考察（y - 1, x)
        if (y != 0 && ! record[y - 1][x]) {
            if (mat[y - 1][x] > mat[y][x]) {
                map.put(mat[y - 1][x], getPosition(y - 1, x));
            }
        }

        // 考察（y, x + 1)
        if (x != xLength - 1 && ! record[y][x + 1]) {
            if (mat[y][x + 1] > mat[y][x]) {
                map.put(mat[y][x + 1], getPosition(y, x + 1));
            }
        }

        // 考察（y + 1, x)
        if (y != yLength - 1 && ! record[y + 1][x]) {
            if (mat[y + 1][x] > mat[y][x]) {
                map.put(mat[y + 1][x], getPosition(y + 1, x));
            }
        }

        // 考察（y, x - 1)
        if (x != 0 && ! record[y][x - 1]) {
            if (mat[y][x - 1] > mat[y][x]) {
                map.put(mat[y][x - 1], getPosition(y, x - 1));
            }
        }

        if (! map.isEmpty()) {
            Map.Entry<Integer, int[]> entry = map.firstEntry();
            int[] position = entry.getValue();
            return findPeak(mat, position[0], position[1]);
        }

        return getPosition(y, x);
    }

    private int[] getPosition(int y, int x) {
        int[] result = new int[2];
        result[0] = y;
        result[1] = x;
        return result;
    }

    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        try (FileReader fileReader = new FileReader("D:\\Software\\Work\\Data\\Idea\\Projects\\java\\datastructure\\src\\data.txt")) {
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
        FindPeakGrid findPeakGrid = new FindPeakGrid();
        int[] result = findPeakGrid.findPeakGrid(mat);
    }

}

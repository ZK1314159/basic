package algorithm.review;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/5 17:10 <br>
 */
public class BinarySearch {

    int search(int aim, int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        return core(aim, ints, start, end);
    }

    int core(int aim, int[] ints, int start, int end) {
        int medium = (start + end) / 2;
        if (start == end) {
            if (aim == ints[medium]) {
                return medium;
            }
            else {
                return -1;
            }
        }
        else if (aim == ints[medium]) {
            return medium;
        }
        else if (aim < ints[medium]){
            return core(aim, ints, start, medium - 1);
        }
        else {
            return core(aim, ints, medium + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < 9 ; i++) {
            ints[i] = i * 2 + 1;
        }
        BinarySearch binarySearch = new BinarySearch();
        int position = binarySearch.search(16, ints);
        System.out.println(position);
    }
}

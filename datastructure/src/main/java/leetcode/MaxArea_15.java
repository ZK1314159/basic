package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/3 16:12 <br>
 */
public class MaxArea_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2 ) {
            return new ArrayList<>();
        }

        List<Integer> plus = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for (int number : nums) {
            if (number > 0) {
                plus.add(number);
            } else if (number == 0) {
                zero.add(number);
            } else {
                minus.add(number);
            }
        }

        // 处理0
        List<List<Integer>> result = new ArrayList<>();
        if (zero.size() > 0) {
            if (zero.size() >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                result.add(list);
            }
            if (plus.size() > 0 && minus.size() > 0) {
                List<Integer> plusNew = plus.stream().distinct().collect(Collectors.toList());
                List<Integer> minusNew = minus.stream().distinct().collect(Collectors.toList());
                for (Integer tmp : plusNew) {
                    if (minusNew.contains(-tmp)) {
                        result.add(getList(0, tmp, -tmp));
                    }
                }
            }
        }

        // 处理正数和负数
        plus = plus.stream().sorted().collect(Collectors.toList());
        minus = minus.stream().map(v -> -v).sorted().collect(Collectors.toList());
        handle(plus, minus, false, result);
        handle(minus, plus, true, result);

        return result;
    }

    public void handle(List<Integer> plus, List<Integer> minus, boolean reverse, List<List<Integer>> result) {
        plus = plus.stream().distinct().collect(Collectors.toList());
        if (plus.size() > 0 && minus.size() > 1) {
            for (Integer tmp : plus) {
                int left = 0;
                int right = minus.size() - 1;
                if (tmp < minus.get(left) * 2) {
                    continue;
                }
                if (tmp > minus.get(right) * 2) {
                    break;
                }
                int last = 0;
                while (left < right) {
                    int minusLefTmp = minus.get(left);
                    int minusRightTmp = minus.get(right);
                    if (minusLefTmp + minusRightTmp > tmp) {
                        right--;
                    } else if (minusLefTmp + minusRightTmp == tmp) {
                        if (minusLefTmp != last) {
                            if (reverse) {
                                result.add(getList(-tmp, minusLefTmp, minusRightTmp));
                            } else {
                                result.add(getList(tmp, -minusLefTmp, -minusRightTmp));
                            }
                        }
                        last = minusLefTmp;
                        left++;
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
    }

    public List<Integer> getList(int a, int b, int c) {
        return new ArrayList<>(Arrays.asList(a, b, c));
    }

    // ________________________________________________________________________________________________________

    public void deleteRepeated(List<Integer> list) {
        if (list.size() <= 2) {
            return;
        }
        Iterator<Integer> iterator = list.iterator();
        int last = 0;
        boolean repeated = false;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(last) ) {
                if (repeated) {
                    iterator.remove();
                } else {
                    repeated = true;
                }
            } else {
                last = next;
                repeated = false;
            }
        }
    }

    public void sortResult(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            List<Integer> newList = list.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                list.set(i, newList.get(i));
            }
        }

        List<List<Integer>> newResult = result.stream()
                // .thenComparing(v -> v.get(1))
                .sorted(Comparator.comparing((List<Integer> v) -> v.get(0))
                        .thenComparing((List<Integer> v) -> v.get(1)))
                .collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            result.set(i, newResult.get(i));
        }
    }

    public void print(List<List<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            List<Integer> tmp = result.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (j == tmp.size() - 1) {
                    System.out.print(tmp.get(j));
                } else {
                    System.out.print(tmp.get(j) + ",");
                }
            }
            System.out.print("],");
            if ((i + 1) % 9 == 0) {
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args) {
//        int[] sample = new int[] {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,
//                -66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        int[] sample = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        MaxArea_15 test = new MaxArea_15();
        List<List<Integer>> result = test.threeSum(sample);
        test.sortResult(result);
        test.print(result);
    }

    //[[-82,-11,93],[-82,13,69],[-82,17,65],[-82,21,61],[-82,26,56],[-82,33,49],[-82,34,48],[-82,36,46],[-70,-14,84],
    //[-70,-6,76],[-70,1,69],[-70,13,57],[-70,15,55],[-70,21,49],[-70,34,36],[-66,-11,77],[-66,-3,69],[-66,1,65],
    // [-66,10,56],[-66,17,49],[-49,-6,55],[-49,-3,52],[-49,1,48],[-49,2,47],[-49,13,36],[-49,15,34],[-49,21,28],
    // [-43,-14,57],[-43,-6,49],[-43,-3,46],[-43,10,33],[-43,12,31],[-43,15,28],[-43,17,26],[-29,-14,43],[-29,1,28],
    // [-29,12,17],[-14,-3,17],[-14,1,13],[-14,2,12],[-11,-6,17],[-11,1,10],[-3,1,2]]

}

package interview.historry.exam2018.cvte;

import java.util.*;

public class Main {
    private int length(List<Integer> list) {
        //剔除list的重复元素，并以递增顺序放入listNew
        TreeSet<Integer> set = new TreeSet<>(list);
        List<Integer> listNew = new ArrayList<>(set);
        int max = listNew.get(listNew.size() - 1);
        final int finalMax = max;
        listNew.remove(listNew.size() - 1);
        //把listNew放入数组，便于操作
        int[] ins = new int[listNew.size()];
        for (int i = 0; i < listNew.size(); i++) {
            ins[i] = listNew.get(i);
        }
        TreeSet<Integer> set2 = new TreeSet<>();
        //计算所有可能的和，去除重复元素，以递增顺序得到所有可能的棍子长度
        for (int i = 0; i < (1 + ins.length) * ins.length / 2; i++) {
            //用一个递归程序countSum实现计算
            set2.add(countSum(finalMax, ins, i));
        }
        List<Integer> listMax = new ArrayList<>(set2);
        //将棍子长度放入数组中，便于操作
        int[] insMax = new int[listMax.size()];
        for (int i = 0; i < listMax.size(); i++) {
            insMax[i] = listMax.get(i);
        }
        //遍历所有可能的棍子长度，验证是否是正确长度
        for (int i = 0; i < insMax.length; i++) {
            //max是对应的假设棍子长度
            max = insMax[i];
            List<Integer> listTmp = new ArrayList<>(list);
            int j = 2;
            if (i == 0) {
                j = 1;
            }
            //看listNew中的元素是不是可以由j个元素求和得到
            for (; j <= listTmp.size(); j++) {
                if (j == 1) {
                    for (int k = 0; k < listTmp.size(); k++) {
                        if (listTmp.get(k) == max) {
                            listTmp.remove(k);
                            //注意坐标的动态性！
                            k--;
                        }
                    }
                    if (listTmp.isEmpty()) {
                        return max;
                    }
                } else {
                    //如果listTmp中有j个元素的和恰好是假设的棍子长度，deal可以除去所有的这些元素
                    //若为空，则证实假设正确
                    if (deal(listTmp, j, max)) {
                        return max;
                    }
                }
            }
        }
        return max;
    }

    private int countSum(int max, int[] ins, int n) {
        return count(max, ins, -1, n);
    }

    private int count(int preMax, int[] ins, int pre, int n) {
        if (pre == ins.length - 2) {
            return preMax + ins[ins.length - 1];
        }
        if (n == 0) {
            return preMax;
        }
        //计算长度的方法：先写趋势在考虑具体边界，通过加一减一达到标准表达式！
        int preSum = (ins.length + ins.length - pre) * (pre + 1) / 2;
        if (pre != -1) {
            preMax += ins[pre];
        }
        int max = 0;
        int i;
        for (i = pre + 1; i <= ins.length - 1 && ++preSum <= n; i++) {
            max = preMax + ins[i];
        }
        if (i == ins.length && preSum < n) {
            return count(preMax, ins, pre + 1, n);
        } else {
            return max;
        }
    }

    private boolean deal(List<Integer> list, int n, int aim) {
        int[] pos = new int[n];
        deal(list, pos, -1, 0, aim);
        return list.isEmpty();
    }

    private void deal(List<Integer> list, int[] pos, int posPre, int posN, int aim) {
        for (pos[posN] = posPre + 1; pos[posN] <= list.size() - 1 - (pos.length - 1 - posN); pos[posN]++) {
            if (posN == pos.length - 1) {
                for (; pos[posN] <= list.size() - 1; pos[posN]++) {
                    int sum = 0;
                    for (int i : pos) {
                        sum += list.get(i);
                    }
                    if (sum == aim) {
                        //注意坐标的动态性！
                        for (int i = pos.length - 1; i >= 0; i--) {
                            list.remove(pos[i]);
                        }
                        if (list.isEmpty()) {
                            return;
                        } else if (pos.length > list.size()) {
                            return;
                        } else {
                            int[] posNew = new int[pos.length];
                            deal(list, posNew, -1, 0, aim);
                        }
                    }
                }
            } else {
                deal(list, pos, pos[posN], posN + 1, aim);
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(6);
        int length = m.length(list);
        System.out.println(length);
    }
}

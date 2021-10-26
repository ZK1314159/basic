package sougou;

import java.util.*;

public class Main {
    private int count(List<Integer> list) {
        int count = 0;
        while (!list.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1) == list.get(i)) {
                    tmp.add(list.get(i));
                }
            }
            count++;
            list = tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.valueOf(s1);
        String s = sc.nextLine();
        String[] st = new String[n];
        int[] arr = new int[n];
        st = s.split(",");
        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.valueOf(st[i]);
        }
        Arrays.sort(arr);
        List<Integer> tmp = new ArrayList<>();
        for (int i : arr) {
            tmp.add(i);
        }
        int num = m.count(tmp);
        System.out.print(num);
    }
}

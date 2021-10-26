package wuba;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Integer> game(int totalNum, int countNum) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < totalNum; i++) {
            list.add(i + 1);
        }
        int off = 0;
        while (list.size() > 0) {
            for (int j = 0; j < countNum - 1; j++) {
                off++;
                if (off == list.size()) {
                    off = 0;
                }
            }
            if (off == list.size() - 1) {
                list2.add(list.get(off));
                list.remove(off);
                off = 0;
            } else {
                list2.add(list.get(off));
                list.remove(off);
            }
        }
        return list2;
    }

    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> list = m.game(7, 6);
        list.forEach(System.out::print);
    }
}

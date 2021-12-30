package javase;

import java.util.ArrayList;
import java.util.List;

public class Stream_Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        int[] arr = list.stream().mapToInt(e -> (int) e).toArray();
        Integer[] arr2 = list.toArray(new Integer[list.size()]);
    }
}

package javase;

import java.util.*;

public class Effective_Final_Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        for (int i = 0; i < list.size(); i++) {

            list.forEach(System.out::print);
            //list.forEach(e -> System.out.print(i));
        }
    }
}

package main.java.javase;

import java.util.ArrayList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/15 14:55 <br>
 */
public class JavaSeTest {
    public static void main(String[] args) {
        int i = 178;
        Integer j = 178;
        System.out.println(j.equals(i));
        System.out.println(i == j);
        System.out.println(j == i);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.remove(2);
        arrayList.forEach(System.out::print);
    }
}

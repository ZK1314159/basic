package main.java.a_test;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：<br>
 * <br>
 * CreateDate：historry.exam2019/12/10 9:43 <br>
 */
public class ForEachTest {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        Set<String> set = new HashSet<>();
        set.add("sdfsd");
        set.add("jfsdkjf");
        set.add("fjah");
        set.add("dfhe");
//        set.forEach(o -> {
//            if ("dfhe".equals(o)) {
//                break;
//            }
//        });
//        for (int i : ints) {
//            if (i == 5) {
//                break;
//            }
//            System.out.println(i);
//        }
        for (String i : set) {
            if ("fjah".equals(i)) {
                break;
            }
            System.out.println(i);
        }
    }
}

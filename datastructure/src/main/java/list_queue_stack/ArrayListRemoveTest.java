package main.java.list_queue_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/5/7 16:45 <br>
 */
public class ArrayListRemoveTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }
//        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        System.out.println(list);

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(1);
        list2.add(4);
        list2.add(1);
        list2.add(5);
        list2.add(9);
        for (int i = 0; i < list2.size(); i++) {
            list2.remove(i);
        }
        System.out.println(list2);


    }
}

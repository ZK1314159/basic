package main.java.a_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/4/16 16:36 <br>
 */
public class ArraySetTest {

    public static void main(String[] args) {
        List<String>[] listArray = new List[10];
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("new");
        list.remove("new");
        listArray[0] = list;
        System.out.println(listArray[0]);
    }
}

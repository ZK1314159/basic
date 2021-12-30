package main.java.a_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/1/17 15:51 <br>
 */
public class ListScanTest {
    public static void main(String[] args) {
        List<Set_Test> list = new ArrayList<>();
        Set_Test sample1 = new Set_Test();
        sample1.id = 1;
        list.add(sample1);
        Set_Test sample2 = new Set_Test();
        sample2.id = 2;
        list.add(sample2);
        Set_Test sample3 = new Set_Test();
        sample3.id = 3;
        list.add(sample3);
        List<Set_Test> listTmp = new ArrayList<>();
        for (Set_Test test : list)  {
            test.id = test.id + 5;
            listTmp.add(test);
        }
    }
}

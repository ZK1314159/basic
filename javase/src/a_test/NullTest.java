package a_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2019/12/16 14:12 <br>
 */
public class NullTest {
    public static void main(String[] args) {
        //NullTest test = new NullTest();
        List<AMap> list = new ArrayList<>();
        AMap sample = null;
        list.add(sample);
        System.out.println(list.size());
    }
}

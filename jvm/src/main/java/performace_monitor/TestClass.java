package performace_monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/1/20 15:51 <br>
 */
public class TestClass {

    public static class Test {

//        char[] space = new char[10];
        int i = 0;

    }

    public static void main(String[] args) {

        List<char[]> list = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            char[] chars2 = new char[20 * 1024 * 1024];
            if (j % 2 == 0) {
                list.add(chars2);
            }
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        char[] result = list.get(0);

//        long id = 0;

//        while (true) {
//            id++;
//        }

//        try {
////            Thread.sleep(3600000);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }

//        char[] space = new char[60 * 1024 * 1024];

//        List<Test> list = new ArrayList<>();
//        while (true) {
//            Test tmp = new Test();
//            list.add(tmp);
//        }


//        new Thread(() -> {
////            List<Test> list = new ArrayList<>();
////            while (true) {
////                list.add(new Test());
////            }
//            List<char[]> list = new ArrayList<>();
//            List<char[]> list2 = new ArrayList<>();
//            for (int i = 0; i < 10000; i++) {
////                char[] chars = new char[100 * 1024];
//                for (int j = 0; j < 100; j++) {
////                    char[] chars = new char[200 * 1024];
//                    if (j % 4 == 0) {
////                        list.add(chars);
//                        char[] chars2 = new char[1 * 1500 * 1024];
//                    }
//                }
////                char[] chars2 = new char[3 * 1500 * 1024];
////                if (i % 10 == 0) {
////                    list.add(chars2);
////                }
////                list.add(new char[1024 * 1024]);
//                if (i < 1000) {
//                    try {
//                        Thread.sleep(3600000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        Thread.sleep(3600000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
////                if (i%100 == 0) {
////                    System.out.println("count" + i);
////                }
//            }
//            char[] result = list.get(0);
//            System.out.println("start");
////            try {
////                Thread.sleep(3600000);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//        }, "test thread").start();
    }

}

package main.java.javase;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/15 15:27 <br>
 */
public class InnerClassTest {

    int i = 4;
    static int cj = 6;

    private static class StaticClass {
        static int si = 2;
        int sj = 3;
        static void say() {
            System.out.println("ss say" + cj);
            new InnerClassTest().new InnerClass().sing();
        }
        void sing() {
            System.out.println("si say" + new InnerClassTest().i);
        }
    }

    class InnerClass {
        int j = 3;
        void sing() {
            System.out.println("si say");
            StaticClass.say();
            new StaticClass().sing();
        }
    }

    public static void main(String[] args) {
        InnerClass inner = new InnerClassTest().new InnerClass();
        System.out.println(inner.j);
        inner.sing();
        StaticClass staticClass = new StaticClass();
        System.out.println(staticClass.si);
        System.out.println(staticClass.sj);
        staticClass.sing();
        staticClass.say();
        //i = 4;
        cj = 7;
    }
}

package main.java.javase;

public class InnerClass_Test {
    static int k = 1;
    int l = 2;

    static class inner {
        static int i = 3;
        int j = 4;

        {
            i = k;
            j = k;
            j = new InnerClass_Test().l;
        }

        static void innerFunction() {
            outFunction();
            new InnerClass_Test().outFunction2();
        }

        void innerFunction2() {
        }

        inner() {
        }
    }

    class inner2 {
        int i = 1;

        public inner2() {
            i = 2;
        }
    }

    static void outFunction() {
        int i = inner.i;
        int j = new inner().j;
        //int k = new inner2().i;
    }

    void outFunction2() {
        int i = inner.i;
        int j = new inner().j;
        int k = new inner2().i;
    }

    public static void main(String[] args) {
        new inner().innerFunction2();
        inner.innerFunction();
        new InnerClass_Test().new inner2();
    }
}

class OtherClass {
    public static void test() {
        InnerClass_Test in = new InnerClass_Test();
        int b = in.l;
        InnerClass_Test.inner2 in2 = in.new inner2();
        int c = in2.i;
        int d = InnerClass_Test.inner.i;
    }
}

package javase;

public class DoubleToInt_Test {
    private boolean test(int n) {
        return n == Math.sqrt(n * n);
    }

    void test2() {
        for (int i = 0; i < 10000; i++) {
            if (!test(i)) {
                System.out.println("wrong!");
            }
        }
    }

    public static void main(String[] args) {
        DoubleToInt_Test ceil = new DoubleToInt_Test();
        //ceil.test2();
        //System.out.println("right!");
        int in = 100;
        double d1 = in;
        double d2 = Math.sqrt(200000000);
        boolean b = d2 == in;
        double d3 = -1.2;
        int in2 = (int) d3;
        double d4 = Math.floor(-1.2);
        double d = Math.ceil(-1.2);
        double d5 = Math.round(-1.2);
        System.out.println(d5);
    }
}

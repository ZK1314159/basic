package main.java.javase;

public class ValueTransfer_Test {
    void test(String s) {
        s = "new";
        System.out.println(s);
    }

    public static void main(String[] args) {
        ValueTransfer_Test vt = new ValueTransfer_Test();
        String s = "test";
        String s2 = "test2";
        s2 = s;
        // vt.test(s2);
        System.out.println(s2);
    }
}

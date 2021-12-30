package main.java.javase;

public class Equals_Test {
    public static void main(String[] args) {
        int in = 1;
        Integer in1 = Integer.valueOf(1);
        Integer in2 = Integer.valueOf(1);
        boolean bo = in1.equals(1);
        boolean bo1 = in1.equals(in);
        boolean bo2 = in2 == in1;
        boolean bo3 = in == in1;
        System.out.print(bo3);
    }
}

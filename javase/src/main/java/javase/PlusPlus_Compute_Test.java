package main.java.javase;

public class PlusPlus_Compute_Test {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        x = (x++ * 3) * x++;
        System.out.println(x);
    }
}

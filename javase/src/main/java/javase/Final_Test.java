package javase;

public class Final_Test {
    private int i = 1;

    public static void main(String[] args) {
        final Final_Test f = new Final_Test();
        f.i = 2;
        Final_Test f2 = new Final_Test();
        //f = f2;
        System.out.print(f.i);
    }
}

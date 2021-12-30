package javase;

public class IsOdd_Test {
    private int count(int n) {

        int num = 0;
        while (n > -100) {
            if (n % 2 == 1 || n % 2 == -1) {
                num++;
            }
            n--;
        }
        return num;
    }

    public static void main(String[] args) {
        IsOdd_Test is = new IsOdd_Test();
        int num = is.count(100);
        System.out.println(num);
    }
}

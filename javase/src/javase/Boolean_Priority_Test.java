package javase;

public class Boolean_Priority_Test {
    public static void main(String[] args) {
        boolean a, b, c, d;
        c = d = false;
        a = b = true;
        d = a || c ^ b;
        System.out.println(d);
    }
}

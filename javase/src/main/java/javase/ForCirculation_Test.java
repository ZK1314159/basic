package main.java.javase;

public class ForCirculation_Test {
    public static void main(String[] args) {
        int sum = 0;
        for (; ; ) {
            sum++;
            if (sum > 100) {
                System.out.println("over");
                break;
            }
        }
        //while循环和for循环使用上没有什么区别
    }
}

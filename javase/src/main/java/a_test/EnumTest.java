package main.java.a_test;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Season.valueOf("SPRING").id);
    }
}
enum Season{
    SPRING(1), SUMMER(2);
    int id;
    private Season(int id){
        this.id = id;
    }
}
package main.java.javase;

class SuperClass {
    static int j = 4;
    int i = 2;

    static void run() {
        System.out.println("superrun");
    }
}

public class Polymorphism_Test extends SuperClass {
    int i = 3;
    static int j = 5;

    static void run() {
        System.out.println("subrun");
    }

    public static void main(String[] args) {
        SuperClass test = new Polymorphism_Test();
        System.out.println(test.i);
        //System.out.println(test.j);
        test.run();

    }
}

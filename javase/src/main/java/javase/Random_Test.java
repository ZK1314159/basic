package main.java.javase;

import java.util.Random;

public class Random_Test {
    public static void main(String[] args) {
        Random r = new Random();
        //double d = r.doubles(3 , 12).findFirst().getAsDouble();
        double[] ds = r.doubles(100, 3, 12).toArray();
        double d3 = ds[0];
        System.out.println(d3);
        //System.out.println(ds.length);
    }
}

package main.java.javase;

import java.util.ArrayList;
import java.util.List;

public class ForEach_Test {
    private static class Person {
        int age = 1;

        Person(int age) {
            this.age = age;
        }

        public String toString() {
            return age + " ";
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(4);
        list.forEach(o -> o = 2);
        list.forEach(System.out::print);
        System.out.println();
        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(3));
        list2.add(new Person(4));
        list2.add(new Person(9));
        list2.add(new Person(1));
        list2.add(new Person(2));
        list2.add(new Person(5));
        list2.forEach(o -> o = null);
        list2.forEach(o -> o.age = 2);
        list2.forEach(System.out::print);
        System.out.println();
        Person[] arr = new Person[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Person(4);
        }
        for (Person p : arr) {
            p.age = 3;
        }
        for (Person p : arr) {
            System.out.print(p.age + " ");
        }
    }
}

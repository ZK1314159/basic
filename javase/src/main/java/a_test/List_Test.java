package a_test;

import java.util.*;

public class List_Test {
    public static void main(String[] args) {
//        Person person = new Person();
//        List<Person> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            person.id = i;
//            person.name = "name is " + person.id;
//            list.add(person);
//        }
//        list.forEach(o -> System.out.println(o.name));

        List<Person> list = new ArrayList<>();
        Person person = null;
        list.add(person);
        list.add(person);
        System.out.println(list.size());
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.forEach(o -> System.out.print(o + " "));
        System.out.println();
        list.add(2, 7);
        list.forEach(o -> System.out.print(o + " "));
        System.out.println();
        list.remove(1);
        list.set(2, 10);
        //list.
        list.forEach(o -> System.out.print(o + " "));
        System.out.println();
        //System.out.print();*/
    }
}
class Person {
    int id;
    String name;
}

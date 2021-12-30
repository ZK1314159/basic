package main.java.reflection;

import java.lang.reflect.Method;

public class Reflection_Method_Test {
    /*public void test(List<String> list , String s)
    {
        list.add(s);
    }*/
    public void test(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        Reflection_Method_Test test = new Reflection_Method_Test();
        //List<String> list = new ArrayList<>();
        //list.add("test");
        //list.add("love");
        Class<Reflection_Method_Test> clazz = Reflection_Method_Test.class;
        Method m1 = clazz.getMethod("test", String.class);
        Method[] m2 = clazz.getMethods();
        Object o = clazz.getConstructor().newInstance();
        m1.invoke(test, "hate");
    }
}

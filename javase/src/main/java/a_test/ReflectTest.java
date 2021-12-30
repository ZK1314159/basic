package a_test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Description：<br>
 *
 * @author zeng.kai <br>
 * CreateDate：historry.exam2019/9/21 15:55 <br>
 * taskId：<br>
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("a_test.Sort");
        Object object = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields[0].getGenericType());
        System.out.println(fields[1].getGenericType());
        System.out.println(fields[2].getGenericType());
        System.out.println(fields[3].getGenericType());
        System.out.println(fields[3].getName());
        Method method = clazz.getMethod("setNumber", int.class);
        method.invoke(object, 2);
        System.out.println("aaa");
        int[] ins = new int[]{1, 2, 3};
        for (Field f : fields){
            System.out.println(f.getName());
        }
    }
}

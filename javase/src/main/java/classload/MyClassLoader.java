package classload;

/**
 * Description
 *
 * @author zengkai
 * Date: 2021/12/1 21:38
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        ClassLoader classLoader = myClassLoader.getParent();
    }
}

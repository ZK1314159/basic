package singleton;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 20:45 <br>
 */
public class Singleton {

    public static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                //如果没有判断，排队进入这段代码的线程会新建对象，导致对象不唯一
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

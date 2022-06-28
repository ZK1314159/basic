package singleton;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 20:45 <br>
 */
public class Singleton2 {

    public static volatile Singleton2 singleton;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (singleton != null) {
            return singleton;
        }
        synchronized (Singleton2.class) {
            //如果没有判断，排队进入这段代码的线程会新建对象，导致对象不唯一
            if (singleton != null) {
                return singleton;
            }
            singleton = new Singleton2();
            return singleton;
        }
    }

}

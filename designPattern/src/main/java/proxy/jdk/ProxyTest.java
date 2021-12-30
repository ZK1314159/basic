package main.java.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/29 20:05 <br>
 */
public class ProxyTest {

    public static void main(String[] args) {
        NormalService normalService = new NormalServiceImpl();
        InvokeHandler invokeHandler = new InvokeHandler(normalService);
        ClassLoader classLoader = normalService.getClass().getClassLoader();
        Class<?>[] classInterface = normalService.getClass().getInterfaces();
        NormalService proxy = (NormalService) Proxy.newProxyInstance(classLoader, classInterface, invokeHandler);
        proxy.test(1234);
    }

}

package main.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/29 20:12 <br>
 */
public class InvokeHandler implements InvocationHandler {

    private NormalService normalService;

    public InvokeHandler(NormalService normalService) {
        this.normalService = normalService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        System.out.println(method.getName() + args[0]);
        Object result = method.invoke(normalService, args);
        System.out.println("invoke finish");
        return result;
    }

}

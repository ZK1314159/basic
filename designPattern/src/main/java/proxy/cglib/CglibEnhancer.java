package proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/29 21:22 <br>
 */
public class CglibEnhancer implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib start");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib end");
        return result;
    }

}

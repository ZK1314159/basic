package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/30 15:32 <br>
 */
public class CglibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new CglibEnhancer());
        Target proxy = (Target) enhancer.create();
        proxy.test("jgkdjk");
    }

}

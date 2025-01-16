package CHAPTER_III._99Proxy.CGLIB;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBHandler implements MethodInterceptor {

    private Object target;
    public CGLIBHandler(Object target){
        this.target = target;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(" Call Method Before init");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println(" Call Method After init");
        return result;
    }
}

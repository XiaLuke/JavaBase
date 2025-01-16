package CHAPTER_III._99Proxy.Jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkInvocationHandler implements InvocationHandler {
    private final Object object;

    public JdkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method");
        Object invoke = method.invoke(object, args);
        System.out.println("after method");
        return invoke;
    }
}

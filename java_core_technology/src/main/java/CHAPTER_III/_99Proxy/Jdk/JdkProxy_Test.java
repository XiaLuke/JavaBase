package CHAPTER_III._99Proxy.Jdk;

import java.lang.reflect.Proxy;

public class JdkProxy_Test {
    public static void main(String[] args) {
        JdkProxy_Service service = new JdkProxy_ServiceImpl();
        // 通过代理拦截器将 service 拦截后增强操作
        JdkProxy_Service proxy = (JdkProxy_Service)Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new JdkInvocationHandler(service)
        );
        proxy.doSomething();
    }
}

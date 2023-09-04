package cn.xf.staticFactoryReplaceConstractor;

public class UseBaseHome {
    public static void main(String[] args) {
        // 通过静态工厂创建的对象，如果对象中不包括公有或受保护的构造器，则不能创建
        BaseHome instance = BaseHome.getInstance();
        instance.setAge(123);
        instance.setName("小明");
        System.out.println(instance);
    }
}

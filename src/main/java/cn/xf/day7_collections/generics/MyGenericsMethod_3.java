package cn.xf.day7_collections.generics;

/*
* 泛型方法：
* 定义一个方法时，常用的是用一个对象进行接收，那么这个接口只能接收该类参数
* 现想要对多个类型的数组进行便利，数组的类型不相同
* */
public class MyGenericsMethod_3 {

    public static void print(String[] strs) {

    }
    
    public static <T> void print(T[] t) {}

    // 将返回值定义为泛型，返回的对象将与形参一致，避免强转
    public static <T> T getMsx(T[] t) {
        return null;
    }
}

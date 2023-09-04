package cn.xf.function.overload;

public class BaseChild extends BaseF {
    // 重写是基于继承的，需要满足方法参数不相同
    // 方法的返回值可以相同，可以不相同
    public int function1(int param1, int param2, int param3) {
        System.out.println("BaseChild function1");
        return param1 + param2 + param3;
    }

    // 被重写的方法返回类型为基本类型时，重写的方法返回类型需要一致
//    public int function2(){
//
//    }

    // 静态方法具有唯一性。不是通过创建对象调用存在，而是实例化对象时生成
    public static void function3(){
    }

    public static void main(String[] args) {
        BaseChild bc = new BaseChild();
        bc.function1(1, 2);
    }
}

package cn.xf.innerClass;

public class NoStaticInnerClass {
    // 非静态内部类
    private class InnerClass {
        // 内部类成员
        int i = 1;
    }
    class InnerClass2 {
        // 内郍置类户
        int i = 2;
    }
}

class TestClass1{

    public static void main(String[] args) {
        NoStaticInnerClass.InnerClass2 innerClass2 = new NoStaticInnerClass().new InnerClass2();
    }
}
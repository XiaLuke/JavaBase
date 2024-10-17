package cn.xf._03Object;

import org.junit.Test;

public class Key_Object {
    String bbb = "abc";

    /**
     * 对于基本数据类型来说，==比较的是两个值是否相等，没有equals()方法
     * 对于引用数据类型来说，==比较的是两个引用的地址是否一致，equals()方法比较的引用对象是否等价
     */
    @Test
    public void function() {
        String ccc = "abc";
        Integer a = new Integer(12);
        Integer b = new Integer(12);
        System.out.println(bbb.equals(ccc));
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(new Key_Object().toString());
    }
}

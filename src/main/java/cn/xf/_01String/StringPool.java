package cn.xf._01String;

import org.junit.Test;

public class StringPool {
    @Test
    public void test1() {
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1);
//        System.out.println(str1.intern());
        // false，在加载系统【sun.misc.Version】的时候就创建了一个java字符串，让如了常量池
        // private static final String launcher_name = "java";
//        System.out.println(str1 == str1.intern());
//        System.out.println(str1.equals(str1.intern()));
    }
}

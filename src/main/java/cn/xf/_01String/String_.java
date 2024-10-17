package cn.xf._01String;

import org.junit.Test;

public class String_ {
    final static char[] value = new char[0];

    /**
     * String2Char
     */
    @Test
    public void StringToChar() {
        String s = "123qwe";
        char[] chars = s.toCharArray();
        System.out.println("原字符串：" + s);
        for (char aChar : chars) {
            System.out.print("String转为Char数组：" + aChar + " ");
        }

        String s1 = new String(new char[]{'a', 'd', 'f', 'g'});
        System.out.println(s1);
    }

    /**
     * String equals
     * equals比较的是两个对象的值
     * == 比较的是两个对象的地址值
     */
    @Test
    public void StringEquals() {
        String a = "asd";
        String b = "asd";
        String c = new String("asd");

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        System.out.println(a==c);
    }

    @Test
    public void stringHash(){
        String a = "123";
        System.out.println(a.hashCode());
    }
}

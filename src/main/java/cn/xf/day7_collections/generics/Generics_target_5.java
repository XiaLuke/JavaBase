package cn.xf.day7_collections.generics;

/*
* 泛型的包装类型
*
* 泛型不支持基本数据类型
*
* 为什么只支持包装数据类型，不支持基本数据类型
* */
public class Generics_target_5 {
    public static void main(String[] args) {
        // 泛型工作在编译阶段，编译后泛型被擦除，变为Object
        // Object是对象类型，不能指向基本数据类型

        // 但是在开发中，也需要让泛型接收数字格式的内容，
        // 所以，引入包装类

        // Integer中提供了缓存数据，数据范围在-128~127，减少内存占用，减少new的次数
        // 在jdk9后不推荐该方式
        Integer num = new Integer(11);
        //
        Integer num1 = Integer.valueOf(1111);

        // 自动装箱：基本数据类型可直接转为包装类型
        Integer num2 = 100;
        // 自动拆箱：包装类型直接传为基本数据类型
        int num3 = num2;

        // 包装类新增功能：
        // 1.将基本类型转为字符串：
        int num4 = 333;
        String s1 = Integer.toString(num4); // "333"
        System.out.println(s1 + 1); // 3331
        // 2.字串数值转基本数据类型
        String s2 = "123";
        int num5 = Integer.parseInt(s2); // 123
    }
}

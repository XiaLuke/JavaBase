package cn.xf.day7_collections.generics;

import java.util.ArrayList;
import java.util.List;

public class MyWildcard_4 {
    public static void main(String[] args) {
        // 将两种类型的list都传给print方法
        List<Wildcard_Car1> list1 = new ArrayList<>();
        list1.add(new Wildcard_Car1());
        list1.add(new Wildcard_Car1());
        list1.add(new Wildcard_Car1());
        print(list1);

        List<Wildcard_Car2> list2 = new ArrayList<>();
        list2.add(new Wildcard_Car2());
        list2.add(new Wildcard_Car2());
        list2.add(new Wildcard_Car2());
//        print(list2);

        List<MyGenericsMethod_3> list3 = new ArrayList<>();
        list3.add(new MyGenericsMethod_3());
        list3.add(new MyGenericsMethod_3());
        print2(list3);// 无法判断当前类型是否满足方法中的定义
    }

    // 操作中发现，若方法接收的参数定义接收了1，那么2会有编译警告；定义接收2，1出现编译警告；若定义使用parent接收，两个都出现警告
    // 使用parent时，虽然parent是1和2的父类，但是ArrayList<parent>与ArraysList<1>,ArrayList<2>没有关系，无法完成转换
    public static void print(List<Wildcard_Car1> list) {

    }

    // 通配符，在使用泛型时，表示一定类型，但是此时，所有List<>类型都能调用print2方法，新的一类可能与1，2没有任何关系
    public static void print2(List<?> list) {

    }

    // 上下限
    /*
    * 泛型上限：? extends parent ,? 能接收一切是parent的子类，但是不能接收非parent的子类
    * 泛型下限：? super parent ,? 能接收一切是parent的父类，但是不能接收非parent的父类
    * */
    public static void print3(List<? super Wildcard_Parent> list) {

    }
    public static void print4(List<? extends Wildcard_Parent> list) {

    }
}

package cn.xf.day7_collections.generics;

import java.util.ArrayList;

/*
* 自定义泛型类
* */
public class MyList_1<E> {
    // 套壳ArrayList,模拟实现了一系列方法
    private ArrayList list = new ArrayList();
    public boolean add(E e){
        list.add(e);
        return true;
    }
}

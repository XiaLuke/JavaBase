package cn.xf._04Collection_Map.collection.list;

import org.junit.Test;

import java.util.*;

/**
 * @Author: 夏帆
 * @date: 2021/4/11 10:36
 * @Version: 1.0
 * @Description List特点：插入块
 *
 * 添加元素有序，可重复，有索引
 */
public class ArrayList_ {

    @Test
    public void function1() {
        /*
        * 实例化空对象集合
        *   初始化长度为10
        * */
        ArrayList c = new ArrayList();
        c.add("12");
        c.add(121);
        c.add(4);
        c.add(55);
        c.add(2, 33);
        System.out.println(c.toString());

        System.out.println(c.size());
        //移出下标对应的元素
        System.out.println(c.remove(3));
        System.out.println("移除指定下标位置后数组为：" + c);

        //移出指定元素第一次出现的位置
        c.remove((Integer) 121);
        System.out.println("删除指定位置的元素后数组为：" + c);

        c.set(1, 45);
        System.out.println("修改第一个位置的元素后数组为：" + c);

        try {
            c.get(4);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("位置不存在");
        }

        //使用增强for循环
        for (Object o : c) {
            System.out.println(o);
        }

        //使用迭代器
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    @Test
    public void function2(){
        ArrayList intArray = new ArrayList<Integer>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        intArray.add(6);
        intArray.add(1,4);
        System.err.println(intArray);
        intArray.remove(4);

        new ArrayList(15);

        System.out.println(intArray.set(2, "33"));

        System.out.println(intArray.size());
        System.out.println(intArray.get(7));
        intArray.trimToSize();
        System.out.println(intArray.size());


    }

}

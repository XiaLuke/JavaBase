package cn.xf._04Collection_Map.collection.set;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author xiafan
 * @version 1.0
 * @date 2021/11/30 15:38
 * @description TreeSet实际上也是调用TreeMap对数据进行操作
 */
public class TreeSetSourceTest {
    @Test
    public void function1() {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(5);

        System.out.println(treeSet);
    }
}

package cn.xf._04Collection_Map.collection.list;

import org.junit.Test;

import java.util.Vector;

/**
 * @Author: 夏帆
 * @date: 2021/4/12 10:03
 * @Version: 1.0
 * @Description:
 */
public class Vector_ {
    @Test
    public void function1() {
        Vector<Integer> intVector = new Vector<>();
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(111);
        intVector.add(1,22);
        intVector.remove(1);
        Vector<Integer> ParamVector = new Vector<>(2);
    }
}

package cn.xf.container;

import org.junit.Test;

import java.util.*;

public class _01Collection {
    @Test
    public void function(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(3);
        treeSet1.add(4);
        treeSet.addAll(treeSet1);
        System.out.println(treeSet.size());

        SortedSet<Integer> integers = treeSet.subSet(0, 6);
        System.out.println(integers);

        HashMap<String, String> stringMap = new HashMap<>();
    }
}

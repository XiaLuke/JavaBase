package cn.xf._04Collection_Map.collection.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Author: 夏帆
 * @date: 2021/4/11 10:36
 * @Version: 1.0
 * @Description:
 */
public class LinkedList_ {

    @Test
    public void function1() {
        LinkedList<Integer> linkedList = new LinkedList();

        //增加
        linkedList.add(25);
        linkedList.add(38);
        linkedList.add(48);
        linkedList.add(58);
        linkedList.add(68);
        linkedList.add(78);
        linkedList.add(1, 56);
        System.out.println("对指定位置添加数据后：" + linkedList);
        Random random = new Random(1);
        for (int i = 1 ; i < 5 ; i++) {
            int i1 = random.nextInt(60);
            linkedList.add(i1);
        }
        linkedList.addFirst(89);
        linkedList.addLast(78);
        System.out.println("添加元素后当前数组" + linkedList);

        //删除
        try {
            linkedList.remove((Integer) 25);
            System.out.println("删除元素后数组为" + linkedList);
        } catch (Exception e) {
            System.out.println("数组中没有该元素");
        }
        System.out.println(linkedList.poll());
        System.out.println("使用pollFirst删除头元素" + linkedList.pollFirst());

        //查 getFirst,getLast,element,indexOf,
        System.out.println("获取当前数组中第一个元素" + linkedList.getFirst());
        System.out.println("获取当期数组中最后一个元素" + linkedList.getLast());
        System.out.println("使用element获取数组中第一个元素" + linkedList.element());
        System.out.println("当前指定元素在数组中出现的位置" + linkedList.indexOf(78));
        System.out.println("当前指定元素在数组中最后出现的位置" + linkedList.lastIndexOf(68));
        //使用for循环遍历
        for (int i = 0 ; i < linkedList.size() ; i++) {
            System.out.println(linkedList.get(i));
        }
        //使用增强for
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        //使用迭代器
        /*Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println("使用迭代器循环"+iterator.next());
        }*/
        //for+iterator
        for (Iterator<Integer> iterator = linkedList.iterator() ; iterator.hasNext() ; ) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void function2() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add("2");
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6); // size =6
        linkedList.add(1, 12);
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println("移除指定位置元素后：" + linkedList);
        linkedList.remove("2");
        System.out.println("移除指定元素后" + linkedList);
        linkedList.removeFirst(); // 直接将下一个结点作为头结点
        System.err.println("移除第一个元素后：" + linkedList);

        linkedList.removeLast(); // 将最后结点指向移除结点的上一结点
        System.err.println("移除最后一个元素后：" + linkedList);

        System.out.printf("pollFirst" + linkedList.pollFirst());

        linkedList.push("19"); // 将元素添加到链表头部
        System.out.println(linkedList);
    }

    public void append(int number){
        ListNode listNode = new ListNode(number);
    }
    public void insert(int position,int number){
    }
}

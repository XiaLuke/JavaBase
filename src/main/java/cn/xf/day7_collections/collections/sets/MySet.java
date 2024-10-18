package cn.xf.day7_collections.collections.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * HashSet如何存数据
 * 哈希值：int 类型随机值，每个对象都有一个根据Object调用hashCode得到hash值
 * 每个对象的hash值都不相同，不同的对象也可能存在相同的hash值，称为hash碰撞（hash类型为int，int的范围为2^32-1）
 * 所以还是可能存在hash碰撞的情况
 * <p>
 * HashSet为什么是无序不重复无索引
 * -> 基于Hash表存储
 * <p>
 * Hash表：1.8之前为 数组+链表存储，8之后为 数组+红黑树存储
 * -> 1.8之前：为创建的HashSet第一次添加数据时，生成长度16的数组，加载因子0.75；
 *
 * @implNote 添加数据时，先计算对象的哈希值，将哈希值与数组长度取模，得到存储下标，
 * 若下标为空，直接添加，不为空时，调用equals判断内容是否相同，相同则跳过，不同将新元素挂到老元素下
 * @implNote 扩容：元素个数超过 长度*加载因子 时，进行扩容；8开始，链长度超过8，数组长度>=64，将链表转成红黑树
 * 扩容
 * <p>
 * 如何去重：HashSet的默认去重是如何实现的
 * 1.即使HashSet能去重，但是当一个对象中，元素重复。HashSet会认为这是两个对象
 * 2.要完成根据内容进行去重，需要重写hashCode与equals方法
 */
public class MySet {
    public static void main(String[] args) {
        // HashSet
        // 无序，不重复，无索引
        Set<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("java");
        hashSet.add("hello");
        System.out.println(hashSet); // [java, world, hello]

        // LinkedHashSet, 有序，不重复，无索引
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
        linkedHashSet.add("java");
        linkedHashSet.add("hello");
        System.out.println(linkedHashSet); // [hello, world, java]

        // TreeSet, 默认升序，不重复，无索引
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("java");
        treeSet.add("hello");
        System.out.println(treeSet); // [hello, java, world]
    }
}

package cn.xf.day7_collections.generics;

/*
* 针对一个对象进行指定内容的一系列操作
* 在项目开发过程中，会出现多个对象有相同的操作，但可自定义具体操作
* 定义泛型接口，在需要使用时实现感性接口，重写相关方法
* */
public interface MyGenerics_2<T> {
    T save(T t);
    T get(int id);
}

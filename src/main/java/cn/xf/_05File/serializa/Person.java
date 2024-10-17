package cn.xf._05File.serializa;

import java.io.Serializable;

public class Person implements Serializable{
    private int age;
    private String name;

    public Person(String haha, int i) {
        this.name = haha;
        this.age = i;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
}

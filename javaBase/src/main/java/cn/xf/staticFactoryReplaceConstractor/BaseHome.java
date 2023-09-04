package cn.xf.staticFactoryReplaceConstractor;

import java.util.Objects;

public class BaseHome {
    private Integer age;
    private String name;

    // 静态工厂方法，可以有一个具体的名称
    // 如果类中不存在构造方法，则不能通过静态方法实例化对象
    public static BaseHome getInstance() {
        return new BaseHome();
    }

    // 普通构造器，名字被固定
    public BaseHome() {
    }

    public BaseHome(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseHome baseHome = (BaseHome) o;
        return Objects.equals(age, baseHome.age) && Objects.equals(name, baseHome.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "BaseHome{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

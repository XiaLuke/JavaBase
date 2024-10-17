package cn.xf.design.simpleFactory;

public class MainTest {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
    }
}

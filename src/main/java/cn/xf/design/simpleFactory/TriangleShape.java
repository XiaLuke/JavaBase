package cn.xf.design.simpleFactory;

public class TriangleShape implements Shape {
    public TriangleShape() {
        System.out.println("TriangleShape: created");
    }

    @Override
    public void draw() {
        System.out.println("draw: TriangleShape");
    }
}
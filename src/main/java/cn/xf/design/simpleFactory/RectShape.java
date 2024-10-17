package cn.xf.design.simpleFactory;

/**
 * 矩形形状
 *
 * @author XF
 * @date 2022/10/06
 */
class RectShape implements Shape {
    public RectShape() {
        System.out.println("RectShape: created");
    }

    @Override
    public void draw() {
        System.out.println("draw: RectShape");
    }
}
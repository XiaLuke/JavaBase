package cn.xf.design.factoryMethod;

class GifReader implements Reader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}
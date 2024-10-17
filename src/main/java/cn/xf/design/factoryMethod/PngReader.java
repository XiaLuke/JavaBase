package cn.xf.design.factoryMethod;

class PngReader implements Reader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}
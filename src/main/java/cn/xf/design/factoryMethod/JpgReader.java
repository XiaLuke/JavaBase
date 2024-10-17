package cn.xf.design.factoryMethod;

class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}
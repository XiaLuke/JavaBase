package cn.xf.design.factoryMethod;

/**
 * 让每个子类决定实例化谁
 *
 * @author XF
 * @date 2022/10/06
 */
class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
package cn.xf.design.stractFactory;

/**
 * 抽象工厂，定义一组需要实现的方法
 *
 * @author XF
 * @date 2022/10/06
 */
public interface AbstractFactory {
    public MapController creatMapController();
    UserController creatUserController();
}

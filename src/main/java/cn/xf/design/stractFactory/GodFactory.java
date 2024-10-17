package cn.xf.design.stractFactory;

/**
 * 在具体的工厂类中创建相应的方法
 *
 * @author XF
 * @date 2022/10/06
 */
public class GodFactory implements AbstractFactory{
    @Override
    public MapController creatMapController() {
        return new GodMapController();
    }

    @Override
    public UserController creatUserController() {
        return new GodUserController();
    }
}

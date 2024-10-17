package cn.xf.design.stractFactory;

public class GodUserController implements UserController{
    @Override
    public void userJump() {
        System.out.println("controller user move");
    }
}

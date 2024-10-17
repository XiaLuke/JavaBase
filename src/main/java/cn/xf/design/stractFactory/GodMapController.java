package cn.xf.design.stractFactory;

public class GodMapController implements MapController {

    @Override
    public void mapChange() {
        System.out.println("create Map");
    }
}

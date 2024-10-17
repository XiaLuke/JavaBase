package cn.xf.reflection.dynamic;

public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see dynamic.proxy.UserService#add()
     */
    public void add() {
        System.out.println("--------------------add---------------");
    }

    public void edit() {
        System.out.println("--------------------edit---------------");
    }
}

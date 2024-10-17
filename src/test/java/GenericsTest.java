package java;

import cn.xf.day7_collections.generics.MyList_1;
import org.junit.Test;

public class GenericsTest {
    @Test
    public void test1(){
        MyList_1<String> list = new MyList_1<>();
//        list.add(111);// 出现异常，泛型定义了只能添加一种类型
        list.add("111");
    }
}

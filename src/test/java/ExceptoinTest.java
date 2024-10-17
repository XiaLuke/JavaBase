package java;

import cn.xf.day7_collections.except.exception.SyncException;
import cn.xf.day7_collections.except.runtimeexception.MyRuntimeException;
import org.junit.Test;

/*
* 编译时异常在发生错误时需要即时捕获并进行处理
* 运行时异常在代码运行阶段发生，不用捕获
*
* 需要关心且加强注意，使用编译形异常
* 不严重的异常，使用运行时异常=====提倡
* */
public class ExceptoinTest {
    @Test
    public void exceptionTest(){
        try {
            checkNum(222);
        } catch (SyncException e) {
            e.printStackTrace();
            System.out.println("执行失败");
        }
    }
    public void checkNum(int num) throws SyncException {
        if(num<0 || num>100){
            throw new SyncException("非法数字");
        }
        System.out.println("通过校验");
    }

    @Test
    public void exceptionRunTest2(){
        checkRuntime(222);
    }
    public void checkRuntime(int num){
        if(num<10 || num>100){
            throw new MyRuntimeException("时间异常");
        }
        System.out.println("通过校验");
    }
}

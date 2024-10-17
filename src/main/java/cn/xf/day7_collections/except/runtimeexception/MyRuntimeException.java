package cn.xf.day7_collections.except.runtimeexception;

// 自定义运行时异常
/*
* 1.继承RuntimeException
* 2.重写构造器
* */
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String message) {
        super(message);
    }
}

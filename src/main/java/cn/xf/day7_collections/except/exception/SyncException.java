package cn.xf.day7_collections.except.exception;

// 自定义编译时异常
/*
* 1.继承Exception
* 2.重写构造器，用来封装原因
* 3.使用到的地方用throw抛出即可
* */
public class SyncException extends Exception{
    public SyncException() {

        super();
    }

    public SyncException(String message) {
        super(message);
    }
}

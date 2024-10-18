package com.tf.simple_factory.util;

import com.tf.simple_factory.item.AddOperate;
import com.tf.simple_factory.item.DivOperate;
import com.tf.simple_factory.item.MulOperate;
import com.tf.simple_factory.item.SubOperate;

public class SFactory {
    public static Operate createOperate(String operate){
        switch (operate) {
            case "+":
                return new AddOperate();
            case "-":
                return new SubOperate();
            case "*":
                return new MulOperate();
            case "/":
                return new DivOperate();
            default:
                throw new IllegalArgumentException("不支持的运算符");
        }
    }
}

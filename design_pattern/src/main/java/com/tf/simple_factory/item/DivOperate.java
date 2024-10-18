package com.tf.simple_factory.item;

import com.tf.simple_factory.util.Operate;

public class DivOperate extends Operate {
    @Override
    public double getResult() {
        if (getNumberB() == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return getNumberA() / getNumberB();
    }
}

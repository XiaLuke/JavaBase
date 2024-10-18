package com.tf.simple_factory.item;

import com.tf.simple_factory.util.Operate;

public class MulOperate extends Operate {
    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}

package com.tf.simple_factory.item;

import com.tf.simple_factory.util.Operate;

public class AddOperate extends Operate {
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}

package CHAPTER_III._5;

import org.junit.Test;

/**
 * @author XF
 * @date 2023/09/04
 * 运算符
 */

public class Operator {

    // integer remainder
    @Test
    public void baseOperation() {
        // add of two numbers
        var sum = 12 + 23;
        // subtraction of two numbers
        var sub = 23 - 2;
        // two numbers multiplication
        var mul = 12 * 2;
        // division
        var div = 22 / 2;
        // find the remainder
        var remain = 32 % 3;

        System.out.printf("the result of add:num = %d\n" +
                        "the result of sub:sub = %d\n" +
                        "the result of mul:mul = %d\n" +
                        "the result of device: device = %d\n" +
                        "the result of remainder: = %d\n",
                sum, sub, mul, div, remain);
    }

    @Test
    public void someException() {
        // 1. when you use integer divided by zero
//        var ex1 = 4 / 0;

        // 2. use floating point number divided by 0, will get Infinity or NaN result
        var ex2 = 2.3 / 0;

        System.out.printf("exception2:%s", ex2);
    }

    /*
     * 3.5.2
     * mathematical functions and constants
     * */
    @Test
    public void getPowerOperation() {
        // use Math.sqrt()
        var baseNum = 4;
        var sq = Math.sqrt(baseNum);

        System.out.printf("the square root of %d is:%.2f \n", baseNum, sq);

        // Math.pow(a,b)
        var powSize = 4;
        var ps = Math.pow(baseNum, powSize);
        System.out.printf("the power of %d is : %.2f \n", baseNum, ps);

        // other Math method, like trigonometric functions,
        // it‘s provide Math.sin;Math.cos;Math.tan;Math.atan;Math.atan2

        // exponential and inverse functions
        // Math.exp;Math.log;Math.log10

        // other Math
        // Math.PI;Math.E
    }

    /*
    * 3.5.3
    * conversion between values
    * */
    @Test
    public void valueChange(){}
}


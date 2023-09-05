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
    public void valueChange() {
        // 1. shaping transformation
        // 1.1 low precision to high precision，When two numbers are added, the result takes the large precision，no loss of accuracy
        // byte range：-128~127
        byte byte_num = 100;
        // short range：-32768~32767
        short short_num = 32667;
        // int range：-2147483648~2147483647
        int int_num = 2146483647;
        // long range：-9223372036854775808~9223372036854775807
        long long_num = 9213372036853775807L;
        var bytePlusShort = byte_num + short_num;
        var shortPlusInt = short_num + int_num;
        var intPlusLong = int_num + long_num;
        var bytePlusLong = byte_num + long_num;
        System.out.printf("the result of byte + short is : %d \n", bytePlusShort);
        System.out.printf("the result of short + int is : %d \n", shortPlusInt);
        System.out.printf("the result of int + long is : %d \n", intPlusLong);
        System.out.printf("the result of byte + long is : %d \n", bytePlusLong);

        System.out.println("------------------------------------------------------------");
        // 1.2 high precision to low precision，will loss of accuracy
        byte short2Byte = (byte) short_num;
        System.out.printf("the result of short to byte is : %d \n", short2Byte);
        var longToint = (int) long_num;
        System.out.printf("the result of long to int is : %d \n", longToint);

        System.out.println("------------------------------------------------------------");

        // 2. char to int
        char char_num = 'a';
        int charToInt = char_num;
        System.out.printf("the result of char to int is : %d \n", charToInt);

        System.out.println("------------------------------------------------------------");
        // 3. floating point type
        // 3.1 float to double, no loss of accuracy
        // float range：1.4E-45~3.4028235E38
        float float_num = 3.4028235E38f;
        // double range：4.9E-324~1.7976931348623157E308
        double double_num = 1.7976931348623157308;
        var floatPlusDouble = float_num + double_num;
        System.out.printf("the result of float + double is : %.2f \n", floatPlusDouble);

        System.out.println("------------------------------------------------------------");
        // 3.2 double to float, will loss of accuracy
        float double2Float = (float) double_num;
        System.out.printf("the result of double to float is : %.2f \n", double2Float);
    }

    /*
     * 3.5.4
     * forced type conversion
     * forced conversion is not safe, it will loss of accuracy
     * Generally used for large precision data to small precision data
     * */
    @Test
    public void forcedConversion() {
        double double_num = 3.1415926;
        int double2Int = (int) double_num;
        System.out.printf("the result of double to int is : %d \n", double2Int);
    }

    /*
     * 3.5.5
     * combining assignment and operators
     * If the operator gets a value of a different type than the value on the left,
     * it is automatically converted to the type of the left
     * like: num += (int)(num + 3.2);
     */
    @Test
    public void combine() {
        int num = 12;
        double double_num = 12.3;
        num += double_num;
        System.out.printf("the result of num += double_num is : %d \n", num);
    }

    /*
     * 3.5.6
     * self increase and self decrease
     * These operators exist in two forms: the prefix form and the suffix form
     * if use prefix form, it will first increase or decrease, then use the value
     * if use suffix form, it will first use the value, then increase or decrease
     *
     * Using the suffix pattern can be misleading,
     * so it is recommended to use the prefix pattern.
     * */
    @Test
    public void selfIncrease() {
        int num1 = 11;
        num1++;
        System.out.printf("the result of num++ is : %d \n", num1);
        num1--;
        System.out.printf("the result of num-- is : %d \n", num1);

        int num2 = 11;
        int a = 2 * num1++; // now num1 is 12
        int b = 2 * ++num2; // now num2 is 13

        System.out.printf("the result of a is : %d \n", a);
        System.out.printf("the result of b is : %d \n", b);
    }

    /*
     * 3.5.6
     * relational and logical operators
     * relational operators: >;>=;<;<=;==;!=
     * logical operators: &&;||;!
     * also java supports ternary operators
     * like: boolean_expression ? expression1 : expression2
     * */
    @Test
    public void relationAndLogic() {
        // relational operators
        // >;>=;<;<=;==;!=
        int num1 = 12;
        int num2 = 23;
        boolean result = num1 > num2;
        System.out.printf("the result of num1 > num2 is : %b \n", result);

        // logical operators
        // &&;||;!
        boolean result1 = num1 > num2 && num1 > 0;
        System.out.printf("the result of num1 > num2 && num1 > 0 is : %b \n", result1);
        boolean result2 = num1 > num2 || num1 > 0;
        System.out.printf("the result of num1 > num2 || num1 > 0 is : %b \n", result2);
        boolean result3 = !(num1 > num2);
        System.out.printf("the result of !(num1 > num2) is : %b \n", result3);

        // ternary operators
        int num3 = 12;
        int num4 = 23;
        int result4 = num3 > num4 ? num3 : num4;
        System.out.printf("the result of num3 > num4 ? num3 : num4 is : %d \n", result4);
    }

    /*
     * 3.5.7
     * bitwise operators
     * &;|;^;~;<<;>>;>>>
     * Bit operations convert the number to binary, then operate
     * */
    @Test
    public void bitwise() {
        // bitwise operators
        // &;|;^;~;<<;>>;>>>
        int num1 = 12; // 0000 1100
        int num2 = 23; // 0001 0111
        int result1 = num1 & num2; // 0000 1100 & 0001 0111 = 0000 0100
        System.out.printf("the result of num1 & num2 is : %d \n", result1);
        int result2 = num1 | num2; // 0000 1100 | 0001 0111 = 0001 1111
        System.out.printf("the result of num1 | num2 is : %d \n", result2);
        int result3 = num1 ^ num2; // 0000 1100 ^ 0001 0111 =  0001 1011
        System.out.printf("the result of num1 ^ num2 is : %d \n", result3);
        int result4 = ~num1; // 1111 0011
        System.out.printf("the result of ~num1 is : %d \n", result4);
        int result5 = num1 << 2; // 0011 0000
        System.out.printf("the result of num1 << 2 is : %d \n", result5);
        int result6 = num1 >> 2; // 0000 0011
        System.out.printf("the result of num1 >> 2 is : %d \n", result6);
        int result7 = num1 >>> 2; // 0000 0011
        System.out.printf("the result of num1 >>> 2 is : %d \n", result7);
    }

    /*
     * 3.5.8
     * operator precedence and brackets
     * if don't use brackets, the operator precedence is: calculated in order of operator precedence
     * Operators of the same level are executed from left to right，except for the assignment operator
     * */
    @Test
    public void precedence() {
        // 1. same level operators
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean result = a && b || c; // equals to: (a && b) || c

        // 2. assignment operator
        int num1 = 12;
        int num2 = 23;
        int num3 = 34;
        num1 += num2 += num3; // equals to: num1 += (num2 += num3)
    }

}


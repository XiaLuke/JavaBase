package cn.xf.fibonaqi;

public class FBNQ {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "个数的斐波那契数为：" + fibonacci(i));
        }
    }

    public static long fibonacci(long num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}

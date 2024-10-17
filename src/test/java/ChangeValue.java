package java;

public class ChangeValue {
    public static void main(String[] args) {
        int a = 0; // 基本类型
        function(a);
        System.out.println(a); // 0

        int[] b = new int[1]; // 引用类型
        function(b);
        System.out.println(b[0]); // 1
    }

    public static void function(int a) {
        a++;
    }

    public static void function(int[] b) {
        b[0]++;
    }
}

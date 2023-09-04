package cn.xf.doublePointer;

public class ReverseString {
    /**
     * 反向字符串
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while (j > i) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;i++;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] str = {'x','a','d','f','v','e','q','n'};
        reverseString(str);
    }
}

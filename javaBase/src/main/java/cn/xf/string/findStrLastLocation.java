package cn.xf.string;

public class findStrLastLocation {
    public static void main(String[] args) {
        String source = "aksdjfkjdflkajfdlkasfd";
        String target = "jfkj";

        int i = source.lastIndexOf(target);
        if(i == -1) {
            System.out.println("null");
        }else {
            System.out.println("出现的位置："+i);
        }
    }
}

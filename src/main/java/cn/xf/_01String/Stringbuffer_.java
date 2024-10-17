package cn.xf._01String;

public class Stringbuffer_ {
    public static void main(String[] args) {
        /*
        * public StringBuffer() {
        *   super(16);
        *   }
        * */
        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer.capacity());
        buffer.append(1);
        buffer.append(23);
        buffer.append(1120L);
        System.out.println(buffer.toString()
        );
        buffer.insert(2,1);
        System.out.println(buffer);

        StringBuffer buffer1 = new StringBuffer(1);
        System.out.println(buffer1.capacity());


        StringBuffer buffer2 = new StringBuffer("2313");
        System.out.println(buffer2.capacity()); // capacity = str.length+16

    }

}

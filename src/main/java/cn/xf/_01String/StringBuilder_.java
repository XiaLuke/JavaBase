package cn.xf._01String;

import org.junit.Test;

/**
 * @Author: 夏帆
 * @date: 2021/4/11 9:38
 * @Version: 1.0
 * @Description:
 */
public class StringBuilder_ {
    public static void main(String[] args) {
        /**
         * 1）直接创建StringBuilder对象时
         *      初始数组长度（value）为16，计数（count）为0
         *      public StringBuilder() {
         *         super(16);
         *     }
         * */
        StringBuilder stringBuilder1 = new StringBuilder();

        /**
         * 2）使用StringBuilder有参构造，参数为int时
         *      该数组容量为int值指定的大小
         *      public StringBuilder(int capacity){
         *          super(capacity);
         *      }
         *
         *      //Creates an AbstractStringBuilder of the specified capacity.
         *      AbstractStringBuilder( int capacity){
         *      value = new char[capacity];
         *      }
         *
         * */
        StringBuilder stringBuilder2 = new StringBuilder(1234);
//        System.out.println(stringBuilder2.capacity());

        /**
         * 3）使用StringBuilder有参构造，参数为String类型时
         *      初始数组长度为(string.length+16)
         *      当使用append追加的字符串长度超过了初始数组长度则进行扩容（int newCapacity = (value.length << 1) + 2;）
         *          即（value.length*2+2）
         *
         *
         *     public StringBuilder(String str) {
         *        super(str.length() + 16);
         *        append(str);
         *     }
         *     //append
         *     public AbstractStringBuilder append(String str) {
         *         if (str == null)
         *             return appendNull();
         *         int len = str.length();
         *         ensureCapacityInternal(count + len); // int count;
         *         str.getChars(0, len, value, count);
         *         count += len;
         *         return this;
         *     }
         *     //ensureCapacityInternal
         *     private void ensureCapacityInternal(int minimumCapacity) {
         *         // overflow-conscious code
         *         if (minimumCapacity - value.length > 0) { // char[] value;   // result:true
         *             value = Arrays.copyOf(value,
         *                     newCapacity(minimumCapacity));
         *         }
         *     }
         *     //newCapacity()
         *     private int newCapacity(int minCapacity) {
         *         // overflow-conscious code
         *         int newCapacity = (value.length << 1) + 2;
         *         if (newCapacity - minCapacity < 0) {
         *             newCapacity = minCapacity;
         *         }
         *         return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
         *             ? hugeCapacity(minCapacity)
         *             : newCapacity;
         *     }
         * */
        StringBuilder stringBuilder = new StringBuilder("ssss");
//        System.out.println(stringBuilder.capacity());


        // 将相邻两个数交换位置
//        StringBuilder builder3 = new StringBuilder("asdfag");
//        String string = builder3.toString();
//        System.out.println(stringBuilder.substring(2));
//        char[] chars = string.toCharArray();
//        System.out.println(chars.length/2);
//        for (char aChar : chars) {
//            for(int i = 0;i<chars.length;i++){
//                char[] temp = new char[chars.length];
//                temp[i] = chars[i+1];
//            }
//        }

        StringBuilder builder3 = new StringBuilder();
        builder3.append("111" + "333" + "444");
        builder3.append("222");
        System.out.println(builder3.toString());

        String str = new String();
        str.concat("22");

    }

    /**
     * StringBuffer/StringBuilder，追加方法（append）
     */
    @Test
    public void append() {
        String result = "time to ";
        String source = "now";
        StringBuffer buffer = new StringBuffer();
        buffer.append(result);
        buffer.append(source);
        System.out.println(buffer);
    }

    /**
     * StringBuffer/StringBuilder，反转字符串（reverse）
     */
    @Test
    public void reverse() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("won ot emit");

        buffer.reverse();
        System.out.println(buffer);
    }

    /**
     * StringBuffer/StringBuilder，删除子字符串
     */
    @Test
    public void delete() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("time xxx to now");

        buffer.delete(5,9);
        System.out.println(buffer);
    }

    /**
     * StringBuffer/StringBuilder，指定位置插入数据
     */
    @Test
    public void insert() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("asdfsdf");

        buffer.insert(4,"xxx");
        System.out.println(buffer);
    }

    /**
     * StringBuffer/StringBuilder，替换字符串中指定位置的字符串
     */
    @Test
    public void replace() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ahhahahahha");

        buffer.replace(0,4,"####");
        System.out.println(buffer);
    }
}

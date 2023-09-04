package cn.xf;

/**
 * 2465年
 *
 * @author XF
 * @date 2023/06/26
 */
public class _2465 {
    public static int solution(String word){
        int n = word.length();
        int num = 0;  // 需要插入的最少字母数
        int count = 0;  // 处理连续的字符时的计数器
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c == 'a') {
                count++;
            } else if (c == 'b') {
                if (count % 2 == 1) {  // 如果不是偶数个 'a'，需要再添加一个 'a' 变为 'ab'
                    num++;
                    count--;
                }
                count += 2;  // 'b' 可以和两个 'a' 组成 'abc'
            } else {  // c == 'c'，需要先处理前面的字符
                if (count % 2 == 0) {  // 如果是偶数个 'a'，可以组成一个 'abc'
                    count++;  // 当前字符可以和一个 'a' 组成 'abc'
                } else {  // 如果不是偶数个 'a'，需要先添加一个 'a' 变为 'ab'，再组成 'abc'
                    num++;
                    count--;
                    count++;  // 当前字符可以和一个 'a' 组成 'abc'
                }
                count++;  // 'c' 与 'abc' 中的 'c' 对应
            }
        }
        if (count % 2 == 1) {  // 处理最后剩余的字符
            num++;
            count--;
        }
        return num + (count / 2);  // 需要插入的最少字母数为添加的 'a'、'b'、'c' 的个数
    }
    public static void main(String[] args){
        int asdfqw = solution("aaa");
        System.out.println(asdfqw);
    }
}

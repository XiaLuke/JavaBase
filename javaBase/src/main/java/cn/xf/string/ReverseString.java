package cn.xf.string;

/**
 * 反向字符串
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * @author XF
 * @date 2023/06/15
 */
public class ReverseString {
    public static String reverseWords(String s) {
        s = s.trim(); // 去掉字符串前后的空格
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            // 如果
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim(); //去掉字符串前后的空格
    }

    public static void main(String[] args) {
        String str = "sakdfj askdjflkasgh sdhh sdfq th qthbg";
        System.out.println(reverseWords(str));
    }
}
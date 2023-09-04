package cn.xf.string;

/**
 * 字符串中是否包含子串
 *
 * @author XF
 * @date 2023/06/25
 */
public class KMP {

    public static int kmp(String text, String pattern) {
        // 构建next数据
        int[] next = getNext(pattern);

        // 记录读取子字符串位置
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            // 不匹配，从上一个字符开始
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            // 父字符串当前位置匹配子字符串当前位置
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 得到下一个
     *
     * @param pattern 字串
     * @return {@link int[]}
     */
    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        /*
         * 数组中每个位置存储的是模式串中`当前字符前缀和后缀的公共最长子串的长度`。通常情况下，一个长度为1的字符串只有一个前缀和后缀，
         * 即为空字符串，所以数组的第一个位置的值初始化为0。
         *
         * 例如，对于模式串“AB”，其前缀有“”，“A”；后缀有“”，“B”，只有空字符串是既是前缀又是后缀，此时公共子串长度为0。
         * 由此可见，若数组的第一个位置初始化为其他的值，则无法正确反映长度为1的字符的前缀后缀信息。
         *
         * 因此，为了保证KMP算法能够正确处理每个字符的前缀后缀，在构建next数组时需要将其第一个位置初始化为0。
         * */
        next[0] = 0;

        // 用于记录当前匹配到的位置。初始值为0。
        int j = 0;
        // 构建next数组。
        // 接下来，从子串的第二个字符开始扫描子串，依次计算next数组的每个元素的值，直到计算到最后一个元素。在计算第i个元素的值时，我们分两种情况：
        // 若pattern[i]与pattern[j]相等，则当前的公共最长子串长度为j+1，因此将next[i]赋值为j+1，并将j的值加1。
        // 若pattern[i]与pattern[j]不相等，则j应该移动到next[j-1]的位置，即当前位置公共最长子串的前缀的下一位，然后继续比较。
        // 这样在经过若干次比较后，就能计算出next数组的所有元素的值了。
        for (int i = 1; i < pattern.length(); i++) {
            // 当前遍历位置与当前记录位置不匹配，重新开始
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            // 当前遍历位置与当前记录位置匹配，继续向后遍历
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            // 记录当前位置是否与当前记录位置匹配
            next[i] = j;
        }
        // 返回的结果中，首次出现的字符为0，如果出现重复的字串，进行编号
        return next;
    }

    public static int strStr(String haystack, String needle) {
        int[] net = getNexts(needle);

        int i = 0;
        for (int j = 0; j < haystack.length(); j++) {
            while (i > 0 && needle.charAt(i) != haystack.charAt(j)) {
                i = net[i - 1];
            }
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
            }
            if (i == needle.length()) {
                return j - i + 1;
            }
        }
        return -1;
    }

    public static int[] getNexts(String str) {
        int[] result = new int[str.length()];
        result[0] = 0;

        int i = 0;
        for (int j = 1; j < str.length(); j++) {
            while (i > 0 && str.charAt(i) != str.charAt(j)) {
                i = result[i - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                i++;
            }
            result[j] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "ABC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDAB";
        int pos = strStr(text, pattern);
        System.out.println("匹配位置：" + pos);
    }
}
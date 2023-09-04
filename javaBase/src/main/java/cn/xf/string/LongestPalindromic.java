package cn.xf.string;

/**
 * 最长回文
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author XF
 * @date 2023/06/14
 */
public class LongestPalindromic {
    /**
     * 中心扩散法
     *
     * @param s 年代
     * @return {@link String}
     */
    public static String centralDiffusionMethod(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome1 = expandAroundCenter(s, i, i);
            String palindrome2 = expandAroundCenter(s, i, i + 1);
            res = res.length() > palindrome1.length() ? res : palindrome1;
            res = res.length() > palindrome2.length() ? res : palindrome2;
        }
        return res;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    /**
     * 暴力枚举法
     *
     * @param s 年代
     * @return {@link String}
     */
    public static String violentEnumerationAct(String s) {
        String res = "";
        // 暴力穷举法，依次遍历后续字符串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && subStr.length() > res.length()) {
                    res = subStr;
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(violentEnumerationAct("askjdfjagdshsdghksdghjduwe"));
    }
}

package cn.xf.string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 *
 * @author XF
 * @date 2023/06/14
 */
public class LongestPublicPrefix {
    /**
     * 分治法
     *
     * 思想是将字符串数组切分成两半，然后依次对左右两个子数组进行递归
     * 该算法的时间复杂度为 O(mnlog n)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组中字符串的个数。该算法的空间复杂度为 O(mlog n)
     *
     * @param strs str
     * @return {@link String}
     */
    public static String divideAndConquerMethod(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftPrefix = longestCommonPrefix(strs, left, mid);
        String rightPrefix = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        for (int i = 0; i < minLen; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLen);
    }

    /**
     * 纵向扫描方法
     * 该算法的时间复杂度为 O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组中字符串的个数。
     *
     * @param strs str
     * @return {@link String}
     */
    public static String longitudinalScanningMethod(String[] strs){
        if(!verify(strs)){
            return "";
        }
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[0];
            char c = temp.charAt(i);
            for (int j = 1; j <strs.length ; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) == c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    /**
     * 横向扫描法
     * 该算法的时间复杂度是 O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组中字符串的个数。
     *
     * @param strs str
     * @return {@link String}
     */
    public static String transverseScanningMethod(String[] strs) {
        if(!verify(strs)){
            return "";
        }
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            temp = getCommonPrefix(temp, strs[i]);
            if (temp.length() == 0) {
                return temp;
            }
        }
        return temp;
    }
    public static String getCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        int result = 0;
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            result++;
        }
        return str1.substring(0,result);
    }
    public static boolean verify(String[] strs){
        if (strs == null || strs.length == 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = {"122312332","123234145","1223124671","122312612"};
        String s = transverseScanningMethod(strs);
        System.out.println(s);
    }
}

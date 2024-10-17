package java;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiafan
 * @version 1.0
 * @date 2021/11/23 21:37
 */
public class OtherTest {
    @Test
    public void function1() throws InterruptedException {
        reverseWords("Let's take LeetCode contest");
    }

    public String reverseWords(String s) throws InterruptedException {
        // 使用StringBuffer提升效率
        StringBuffer stb = new StringBuffer();
        // 记录起始位置
        int start = 0;
        int length = s.length();
        while (start < length) {
            // 记录从哪里开始读取
            int begin = start;
            // 根据空格分割每一个单词
            while (start < length && s.charAt(start) != ' ') {
                start++;
            }
            // 向buffer中放值
//            System.out.println("begin"+begin);
            for (int i = start ; i >= 0 ; i--) {
                System.out.println(s.charAt(i));
                Thread.sleep(500);
            }
            while (start < length && s.charAt(start) == ' ') {
                start++;
            }
        }
        System.out.println(stb.toString());
        return stb.toString();
    }

    @Test
    public void function2() {
        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "设计模式");
        books.put(
                "978-1617291999", "java8实战");
        books.put("978-0134685991", "Effective Java");
        List<String> optionalIsbn = books.entrySet().stream()
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.err.println(optionalIsbn);

    }

    @Test
    public void Stri() {
//        System.out.println(sss());
        System.out.println(isAnagram("rewqrewq", "qwerqwer"));
    }

    public int sss() {
        String str = "leetcode";

        //  如何保证map中有序？

        HashMap<Object, Integer> map = new HashMap<>();
        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }
        System.out.println(map);

        Object a = null;
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() == 1) {
                a = entry.getKey();
                break;
            }
        }

        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if (a.equals(ch)) {
                return i;
            }
        }
        return -1;
    }

    // 有效的字母异位词算法
    public boolean isAnagram(String s, String t) {
        HashMap<Object, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }

        for (int i = 0 ; i < t.length() ; i++) {
            char ch = t.charAt(i);
            int count = map.getOrDefault(ch, 0);
            if (count > 0) {
                count--;
                if (count > 0) {
                    map.put(ch, count);
                } else {
                    map.remove(ch);
                }
            }
        }
        if (map.size() != 0) {
            return false;
        } else {
            return true;
        }


    }


}

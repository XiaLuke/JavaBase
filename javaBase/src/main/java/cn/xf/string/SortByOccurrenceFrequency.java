package cn.xf.string;

import java.util.*;

public class SortByOccurrenceFrequency {
    public static String frequencySort(String s) {
        // 声明一个全字母数组
        int[] count = new int[128];
        int n = s.length();
        // 遍历字符串，获取每个字母对应下标，为其增加出现次数
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }

        // 遍历count数组，得到一个下标为出现次数，值为字符的List
        List<Character>[] buckets = new List[n + 1];
        // 遍历128个字符
        for (int i = 0; i < 128; i++) {
            // 如果不为0表示在字符串中出现过，出现则在当前位置创建List，保存出现当前次数的字符
            if (count[i] > 0) {
                if (buckets[count[i]] == null) {
                    buckets[count[i]] = new ArrayList<>();
                }
                buckets[count[i]].add((char) i);
            }
        }

        //从后向前遍历（在上一步已经将出现次数与List下标挂钩）
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    // 遍历出现次数，得到结果
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String frequencySort2(String s) {
        Map<Character, Integer> saveMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 查看map中是否存在这个值，不存在使用默认值0
            int i1 = saveMap.getOrDefault(c, 0) + 1;
            saveMap.put(c, i1);
        }
        List<Character> keyList = new ArrayList<>(saveMap.keySet());
        Collections.sort(keyList, (a, b) -> saveMap.get(b) - saveMap.get(a));
        int size = keyList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Character charc = keyList.get(i);
            Integer integer = saveMap.get(charc);
            for (Integer j = 0; j < integer; j++) {
                sb.append(charc);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "addddccceesstttttggggggghhhh";
        System.out.println(frequencySort(str));
    }
}

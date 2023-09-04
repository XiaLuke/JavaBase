package cn.xf.string;

import java.util.*;

public class MaxCountSender {
    public static String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < messages.length ; i++) {
            String value = messages[i];
            String[] s = value.split(" ");
            int count = s.length;
            if (valueMap.containsKey(senders[i])) {
                int sum = valueMap.get(senders[i]) + count;
                valueMap.put(senders[i], sum);
            } else {
                valueMap.put(senders[i], count);
            }
        }

        // 比较数量
        int max = 0;
        String result = null;
        for (Map.Entry<String, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            } else if (entry.getValue() == max) {
                if (result == null || entry.getKey().compareTo(result) > 0) {
                    result = entry.getKey();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};
        String s = largestWordCount(messages, senders);
        System.out.println(s);
    }
}

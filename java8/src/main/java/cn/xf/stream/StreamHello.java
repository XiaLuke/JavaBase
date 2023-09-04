package cn.xf.stream;

import ch.qos.logback.core.testUtil.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamHello {
    public static void main(String[] args) {
        List<Integer> list = createIntList();
        System.out.printf("list1 = %s\n", list);
        list.sort((Integer a, Integer b) -> a.compareTo(b));
        System.out.printf("list2 = %s\n", list);
    }

    public static List<Integer> createIntList() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(1000) + 1;
            result.add(randomNumber);
        }
        return result;
    }
}

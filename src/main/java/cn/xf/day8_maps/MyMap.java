package cn.xf.day8_maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 整体特点：数据由键值对表示，键不允许重复，值可以重复
 * 包括实现类：
 * - HashMap：无序不重复无索引
 *      - LinkedHashMap：有序不重复无索引
 * - TreeMap：按照大小默认升序排休，无重复无索引
 * */
public class MyMap {
    public static void main(String[] args) {
        // HashMap
        // 通过泛型定义添加数据的类型
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","18");
        map.put("pk","1");
        System.out.println(map); // {pk=1, name=张三, age=18}

        // LinkedHashMap
        Map<String,String> linkedMap = new LinkedHashMap<>();

    }
}

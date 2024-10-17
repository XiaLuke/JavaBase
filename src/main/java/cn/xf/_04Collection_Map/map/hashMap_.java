package cn.xf._04Collection_Map.map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class hashMap_ {
    @Test
    public void function() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("first", 123);
        hashMap.put("second", 234);
        hashMap.put("third", 345);
        hashMap.put("fourth", 456);
        hashMap.put("fifth", 567);
        hashMap.put("first", 1234);

        hashMap.get("xxx");

    }
    @Test
    public void func2(){
        System.out.println(15&110183);
        // 15---------0000 0000 0000 0000 1111
        // 110183-----0001 1010 1110 0110 0111
        // result-----0000 0000 0000 0000 0111
    }
}

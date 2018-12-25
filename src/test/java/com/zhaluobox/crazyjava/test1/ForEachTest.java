package com.zhaluobox.crazyjava.test1;

import org.junit.Test;

import java.util.*;

/**
 * 测试forEach方法
 */
public class ForEachTest {

    @Test
    public void arrTest() {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(1312);
        list.add(1311);
        list.add(12);
        for (Integer ii : list) {
            System.out.println(ii + 3);
        }
        list.forEach((i) -> {
            System.out.println(i + 3);
        });

    }

    @Test
    public void mapTest() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("西游记", 112);
        map.put("水浒传", 993);
        map.put("红楼梦", 322);
        map.put("三国演义", 998);
        System.out.println("--------------------map的原始遍历方式 1-----------------------");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " :  " + map.get(key));
        }
        System.out.println("--------------------map的原始遍历方式 2-----------------------");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> mp : entries) {
            String key   = mp.getKey();
            Object value = mp.getValue();
            System.out.println(key + " :  " + value);
        }
        System.out.println("--------------------map的Lamdba遍历方式 3-----------------------");
        map.forEach((key,value)->{
            System.out.println(key+ " :  " + value);
        });

    }
}

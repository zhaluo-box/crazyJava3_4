package com.zhaluobox.crazyjava.chapter08.section06.practice;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTest {

    static Map<String, Object> map = new HashMap<>();

    /**
     * map 中的key 不可以重复; value可以重复
     */
    @Before
    public void before() {

        map.put("牛顿", 1000);
        map.put("爱因斯坦", 999);
        map.put("爱迪生", "电");
        map.put("特斯拉", "交流电");

    }

    @Test
    public void apiTest() {

        System.out.println("-----------apiTest Start---------------");
        System.out.println();
        /*
        假如放入对某个key进行覆盖.会返回原本的key
         */
        Object o = map.put("爱迪生", "发明电灯泡");
        System.out.println(Objects.toString(o));

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println("是否包含某个key.包含返回true,反之false  :  " + map.containsKey("爱迪生"));
        System.out.println("是否包含某个value.包含返回true,反之false:  " + map.containsValue("爱迪生"));

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println("根据指定key,返回对应的value.如果不存在该key,返回null:  " + map.get("adb"));
        System.out.println("根据指定key,返回对应的value.如果不存在该key,返回null:  " + map.get("爱迪生"));

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println("判断map是否为空:   " + map.isEmpty());

        /*
        putAll 的前提是 泛型一致,否则编译出错
         */
        HashMap<String, Object> mmap = new HashMap<>();
        mmap.put("998", "只要998 买不了吃亏买不了上当");
        mmap.put("111", "110 120 119");

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println("原始map key_value 对数 : " + map.size());
        map.putAll(mmap);
        System.out.println("putAll后 key_value 对数 : " + map.size());

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println(" ---------remove 返回的性质类似于get ---------");
        System.out.println("remove 删除指定key的value 如果key不存在 返回null : " + map.remove("111"));
        System.out.println("remove 删除指定key的value 如果key不存在 返回null : " + map.remove("9999"));

        System.out.println();
        System.out.println("--------------美丽的分割线-----------");
        System.out.println(" remove key_value 对 成功 true, 反之 false :  " + map.remove("111", 999));

        System.out.println();
        System.out.println("-----------apiTest End---------------");

    }


    @Test
    public void java8ApiTest() {


        /*
        Object compute(Object key,BiFunction fm): 该方法使用 fm 根据原来的key-value计算一个新的value值
        假如新的value 不为null 则替换掉旧的value;
        假如新的value 和旧的的value 都为null ,则对本条键值对不做任何改变,其实改变也没有任何意义,反正都一样
        假如旧的value 不为null 但是计算得出的新的value为null, 则删除本条键值对
         */

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("compute:");
        System.out.println("--------------------------------------");
        System.out.println(" 假如新的value 不为null 则替换掉旧的value: ");
        Object o = map.compute("爱迪生", (key, value) -> key + value);
        System.out.println(Objects.toString(o));
        System.out.println(map.get("爱迪生"));
        System.out.println(" 假如旧的value 不为null 但是计算得出的新的value为null, 则删除本条键值对: ");
        Object a = map.compute("爱迪生", (key, value) -> null);
        System.out.println(map.get("爱迪生"));


        /*
        Object computeIfAbsent(Object key,Function mf): 如果传给该方法的key参数在Map中对应的value为null,
        则使用mf 根据key计算一个新的value:
            如果新的value不为null, 则覆盖原来的value
            如果map中不包含该Key 则会添加一组新的键值对;
         */

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("computeIfAbsent:");
        System.out.println("--------------------------------------");
        System.out.println("如果map中不包含该Key 则会添加一组新的键值对;");
        map.computeIfAbsent("爱迪生", key -> key.length()
        );
        System.out.println(map.get("爱迪生"));

        /*
        前提是传给该方法的key参数的value为null
         */
        map.put("aaa",null);
        System.out.println("如果新的value不为null, 则覆盖原来的value");
        map.computeIfAbsent("aaa", key -> (key.length()+key)
        );
        System.out.println(map.get("aaa"));


        /*
         Object computeIfPresent(Object key,BiFunction rf) :
         如果传给该方法的key参数在Map中对应Value不为null,
         则该方法使用rf根据原key,value计算一个新的value,
                如果新的value不为null.则覆盖原来value
                如果新的value为null.则删除该键值对

            前提是传入key的value不为null
         */
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("computeIfPresent:  ");
        System.out.println("--------------------------------------");
        System.out.println("如果新的value不为null.则覆盖原来value");
        Object aaa = map.computeIfPresent("aaa", (key, value) ->{
            return key.length()+((String)value).length()+"";
        } );
        System.out.println(map);

        System.out.println("如果新的value为null.则删除该键值对");
        map.computeIfPresent("aaa", (key, value) ->{
            return null;
        } );
        System.out.println(map);

        /*
        Object getOrDefault(Object key,V dValue) : 获取指定key对应的value,如果该key不存在.则返回DValue;
         */
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("getOrDefault:");
        System.out.println("--------------------------------------");
        Object ads = map.getOrDefault("爱迪生", 998);
        System.out.println(ads);


        /*
        Object merge(Object key,Object value,BiFunction rf) :
         该方法会先根据Key参数获取该Map中对应的value,
            如果key对应的value为null,
                则直接用传入的value覆盖原有的value
                    (在这种情况下如果传入的value也为null则删除该key);
            如果key对应的value不为null,
                则使用rf函数根据原value与
                    新value计算一个新的结果,并用得到的结果去覆盖原有的value;
         */
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("merge:");
        System.out.println("--------------------------------------");
        map.put("劳力士",null);
        map.merge("劳力士","998",(oldValue,newValue)->{
            return oldValue+""+newValue;
        });
        System.out.println(map);

        /*
        注意虽然,方法没有要求 value的值不可以传入null,如果传入了null就会抛出空指针异常
        查看源码.merge 默认方法 中第一步就是对传入的参数进行非空校验.
        --
            以下为源码片段
                Objects.requireNonNull(remappingFunction);
                Objects.requireNonNull(value);
            值得一提的是key 可以传入null
         */
//        map.merge("劳力士",null,(oldValue,newValue)->{
//            return oldValue+""+newValue;
//        });
//        System.out.println(map);
        map.merge("劳力士","998",(oldValue,newValue)->{
            return null;
        });
        System.out.println(map);
        map.merge("爱因斯坦","998",(oldValue,newValue)->{
            return oldValue+""+newValue;
        });
        System.out.println(map);

    }
}

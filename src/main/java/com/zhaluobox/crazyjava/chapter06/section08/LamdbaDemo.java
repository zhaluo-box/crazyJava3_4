package com.zhaluobox.crazyjava.chapter06.section08;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;


/**
 * 定义一个函数式接口
 */
@FunctionalInterface
interface Ttttt
{
    Integer get(int title);
}

@FunctionalInterface
        //JVM编译的时候提醒检测是否是函数式接口
interface fire {

    //定义一个类方法
    static String getMethodName() throws NoSuchMethodException {

        return fire.class.getMethod("getMethodName").getName();
    }

    //定义一个抽象方法
    void ff(String str);

    // 默认方法
    default int getNum(int a, int b) {
        return a + b;
    }
}

@FunctionalInterface
interface Conver{
    Integer convert(String from);
}

@FunctionalInterface
interface Ainter {

    Integer getMax(Integer a, Integer b);

}

/**
 * 演示lamdba
 */
public class LamdbaDemo {

    public void lamdbaTest(fire fire) {
//        System.out.println("=======lamdba表达式==========");
    }

    @Test
    public void test1() {

        System.out.println("=======匿名内部类==========");
        String s = "燃烧我的卡路里";
        fire f = new fire() {
            @Override
            public void ff(String str) {
                System.out.println(getNum(1, 2)); //可以调用默认方法
                System.out.println(str);
            }
        };
        f.ff(s);
        System.out.println(f.getNum(1, 2));

        System.out.println("=======lamdba表达式==========");
        /**
         * 相比较之下lamdba表达式只能去实现函数式 接口中的抽象方法.其他统统不能
         * @param s1 形参列表与函数式接口中的唯一抽象方法的形参是一样的
         *           代码块中不能调用默认方法
         */
        fire fire = (s1) -> {
            System.out.println(s1);
//          System.out.println(getNum(1,2));  //Lamdba 代码块中不允许调用默认方法
        };
        fire.ff(s);
        fire.getNum(1, 2);
        try {
            String methodName = com.zhaluobox.crazyjava.chapter06.section08.fire.getMethodName();
            System.out.println(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("----------Lamdba 只有一条return 语句的情况下省略return与花括号--------");
        Ainter ainter = (a, b) -> a - b > 0 ? a : b;
        Integer max = ainter.getMax(3, 21);
        System.out.println(max);
    }

    /**
     * 下面以 java8 改进的forEach() 方法为例演示lamdba 表达式
     */
    @Test
    public void arrTest() {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(1312);
        list.add(1311);
        list.add(12);

        System.out.println("---------------增强for遍历");
        for (Integer ii : list) {
            System.out.println(ii + 3);
        }

        System.out.println("----------------传统lamdba的方式");
        list.forEach((i) -> {
            System.out.println(i + 3);
        });

        System.out.println("=========传入匿名内部类的方式======");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-----------引用类方法");
        list.forEach(System.out::println);

        System.out.println("-----------某类对象的特殊引用方法");
        Ainter aa = (a,b) -> a.compareTo(b);

        System.out.println("=======引用特定对象实例的方法=======");
        Conver converter = "fkit.org"::indexOf;

        System.out.println("=======引用构造器=======");
        Ttttt ttttt = Integer::new;
        System.out.println( ttttt.get(1));

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

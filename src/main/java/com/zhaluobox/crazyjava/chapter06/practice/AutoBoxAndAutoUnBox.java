package com.zhaluobox.crazyjava.chapter06.practice;

import org.junit.Test;

public class AutoBoxAndAutoUnBox {

    /**
     * 演示自动装箱与拆箱
     */
    @Test
    @SuppressWarnings("all")
    public void autoBoxAndAutoUnBoxTest() {

        int b = 12;
        // 自动装箱
        Integer i = b;
        //自动拆箱
        int a = i;
        // JDK 1.5 以前 基本数据类型转成包装类的方式;都是依赖构造方法
        Integer c = new Integer(12);
        Integer d = new Integer("12");
        // JDK 1.5 以前 包装类转成基本数据类型
        int cc = c.intValue();
        int dd = d.intValue();
        System.out.println(cc);
        System.out.println(dd);

        /*
            结果:
                12
                12
        */
    }

    @Test
    public void stringTest() {

        //String 提供的重载的valueOf() 方法
        System.out.println("--------------基本类型转String---------------------------------");
        System.out.println("--------------String.valueOf(  )---------------------------------");
        System.out.println("=======int 转 String : " + String.valueOf(12));                      //=======int 转 String : 12
        System.out.println("=======long 转 String : " + String.valueOf(1000l));              //=======long 转 String : 1000
        System.out.println("=======double 转 String : " + String.valueOf(33.33d));           // =======double 转 String : 33.33
        System.out.println("=======boolean 转 String : " + String.valueOf(true));            //=======boolean 转 String : true
        System.out.println();

        // 包装类提供的parseXXX()与构造器();
        int i3 = Integer.parseInt("12");
        System.out.println("======Integer parseInt()" + i3);
        double v = Double.parseDouble("123.22");
        System.out.println("======Integer parseInt()" + v);

        //基本类型装字符串.最简单的方法 + "";
        String ss = 123 + "";
    }

    /**
     * Integer 的特殊性
     * Integer缓存设计 -128~127 刚好是short的范围
     */
    @Test
    public void integerTest() {
        int i1 = 220;
        Integer i2 = 220;
        System.out.println("基本数据类型与缓存以外的Integer实例比较" + (i1 == i2));
        Integer a = 12;
        Integer b = 12;
        System.out.println("两个缓存内的包装类(Integer)进行比较" + (a == b));
        Integer i3 = 220;
        System.out.println("两个缓存外的包装类(Integer)进行比较" + (i2 == i3));
        /*    结果:
         *      基本数据类型与缓存以外的Integer实例比较true
                两个缓存内的包装类(Integer)进行比较true
                两个缓存外的包装类(Integer)进行比较false
         */

        /**
         * 结论.
         *          基本类型与包装了进行比较.不论数据是否在包装类的缓存中. 比较的结果都是正确的
         *          两个包装类比较,就要对比.这两个数据在不在缓存中了.  在结果就是正确的
         *          不在结果就是错误的.因为他们比较的是地址值,而不是数字;
         */
    }

    /**
     * JDK 7 新增的compare 方法
     * 返回结果 1 代表 大于
     * 0 代表 等于
     * -1代表 小于
     */
    @Test
    public void compareTest() {

        /*
         *比较特殊的boolean的比较
         */
        System.out.println(Boolean.compare(true, false));    //1
        System.out.println(Boolean.compare(false, false));   //0
        System.out.println(Boolean.compare(false, true));    //-1
        System.out.println(Boolean.compare(true, true));     //0
        System.out.println("===========================");

        Integer i = 10;
        Integer s = 1222;
        System.out.println(Integer.compare(i, s));   //-1

    }

}

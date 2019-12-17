package com.example.javademo.apidemo;

import lombok.Data;
import org.springframework.util.StopWatch;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {

        StopWatch sw = new StopWatch();
        sw.start("init");
        Integer[] ints = new Integer[1000000];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) Math.floor(Math.random() * 100);
        }

        sw.stop();
        System.out.println("总耗时" + sw.getTotalTimeMillis());
        System.out.println("sw.getId()======" + sw.getId());
        System.out.println("sw.getLastTaskInfo()======" + sw.getLastTaskInfo());
        System.out.println("sw.getLastTaskName()======" + sw.getLastTaskName());
        System.out.println("sw.getLastTaskTimeMillis()======" + sw.getLastTaskTimeMillis());
        System.out.println("sw.getTaskCount()======" + sw.getTaskCount());
        System.out.println("sw.getTaskInfo()======" + sw.getTaskInfo());
        System.out.println("sw.getTotalTimeSeconds()======" + sw.getTotalTimeSeconds());

        sw.start("sort");
        String[] strs = {"赵赵", "张三", "李四", "王五", "赵六"};
//        Arrays.parallelSort(ints); //并发排序结果342
        Arrays.sort(ints); //并发排序结果354
        //*对于并发排序.要在数据量超级大的时候才使用.数据量晓得时候还不如原始的方法
        sw.stop();

        System.out.println("并发排序结果" + sw.getTotalTimeMillis());
    }

    /**
     * java8 Arrays API
     * java8 增强了 Arrays 这个工具类,使得其更加强大
     */
    private static void arraysDemo() {

        int[]    ints = {1, 2, 3, 9, 2, 5, 4, 9, 10};
        String[] strs = {"赵赵", "张三", "李四", "王五", "赵六"};  //对string[] 排序====[张三, 李四, 王五, 赵六, 赵赵]

        Arrays.sort(ints, 4, 7);      //对一部分索引进行排序
        System.out.println(Arrays.toString(ints));      //[1, 2, 3, 9, 2, 4, 5, 9, 10]

        Arrays.sort(ints);                              //对数组进行排序
        System.out.println(Arrays.toString(ints));      // [1, 2, 2, 3, 4, 5, 9, 9, 10]

        Arrays.sort(strs);
        System.out.println("对string[] 排序====" + Arrays.toString(strs));

        int i = Arrays.binarySearch(ints, 4);      //采用二分法查询key值在数组中出现的索引位置,如果没有key,就返回-1
        System.out.println(i);                          // 4

        int i1 = Arrays.binarySearch(ints, 2, 7, 4);
        System.out.println("4在4-7中的索引位置===" + i1);    //4在4-7中的索引位置===4


        int[] arrs = Arrays.copyOfRange(ints, 0, 5);
        System.out.println("范围赋值====" + Arrays.toString(arrs)); //范围赋值====[1, 2, 2, 3, 4]

        int i2 = Arrays.binarySearch(strs, "赵赵");
        System.out.println("赵赵的位置====" + i2);                     //赵赵的位置====4


        Arrays.fill(strs, 1, 3, "刘备");
        //修改只包括前面索引不包括后面的索引,也就是只修改1,2索引不修改3 索引
        System.out.println("将索引1-3的值改成刘备++++==" + Arrays.toString(strs)); //将索引1-3的值改成刘备++++==[张三, 刘备, 刘备, 赵六, 赵赵]

        String[] arrStrs = {"敌敌畏", "毒鼠强", "666"};
        System.arraycopy(strs, 0, arrStrs, 0, 2);  //srcpos  源数组起始位置,destpos 目标数组起始位置,length赋值长度
        System.out.println("=========" + Arrays.toString(arrStrs));
    }

    /**
     * 比较存储引用对象时候内部的引用变量的值
     * <p>
     * 存储引用变量.存储的还是栈内存中的引用值.而不是实际的对象
     */
    private static void arrStackAndHeap() {
        Student[] students = new Student[2];

        Student zhang = new Student();
        zhang.setAge(12);
        zhang.setName("张三");

        Student li = new Student();
        li.setAge(12);
        li.setName("李四");

        students[0] = zhang;
        students[1] = li;

        System.out.println(zhang.equals(students[0]));  //结果是true;
        /*
         *  结果为true 代表存储的引用变量的,也就是student的栈内存的引用值.
         *  指向的还是zhang在堆内存的值.
         *  zhang和student[0]其实指向的是同一个目标
         */
    }

    /**
     * 数组的内存变化
     */
    private static void arrsDemo() {
        int[] a = {1, 2, 3, 4};
        int[] b = {6, 7, 8};

        System.out.println("a的长度===" + a.length);  //  4
        System.out.println(a);                      // 原本a 的引用变量 [I@4f023edb
        System.out.println("b的长度===" + b.length);  //  3
        System.out.println(b);                      // 原本b 的引用变量 [I@3a71f4dd
        a = b;
        System.out.println("_________======__________");
        System.out.println("b赋值给a后的长度 ===" + a.length);  //3
        System.out.println(a);                      //  将b赋值给a 后 引用变量发生了变化[I@3a71f4dd
        /*
         *看似数组的长度发生了变化.其实是数组的引用变量发生了变化
         *数组的长度是不可变的.变得只是引用变量.他们的指向堆内存的区域发生了变化
         *其中a数组原本的那块内存区域.没有 了变量去引用就会被标记为垃圾.等待回收
         */
    }

    /**
     * 定义数组的两种方式
     */
    private static void defineArr() {
        //定义数组的两种方式
        int[] arrs;
        int   arr[];

        arrs = new int[]{1, 2, 3};

        int arr1 = arrs[1];
        System.out.println(arr1);
        System.out.println(arrs);
    }
}

@Data
class Student {

    String name;
    Integer age;

}

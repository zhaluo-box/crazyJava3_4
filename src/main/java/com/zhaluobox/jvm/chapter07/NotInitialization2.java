package com.zhaluobox.jvm.chapter07;

/**
 * 被动使用类字段演示二
 *  通过数组定义来引用类, 不会触发此类的初始化
 */
public class NotInitialization2 {

    public static void main(String[] args) {
        SuperClass[] ss = new SuperClass[10];
    }
}

package com.zhaluobox.juc.chapter16.practice.section02;

public class Test1 {
    public static void main(String[] args) {
        ThreadCreateMethodOne thread = new ThreadCreateMethodOne();
        thread.setName("窗口1");
        thread.start();
        ThreadCreateMethodOne thread2 = new ThreadCreateMethodOne();
        thread2.setName("窗口2");
        thread2.start();
    }
}

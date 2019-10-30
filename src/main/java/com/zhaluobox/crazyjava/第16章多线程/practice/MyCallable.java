package com.zhaluobox.crazyjava.第16章多线程.practice;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        return sum;
    }
}

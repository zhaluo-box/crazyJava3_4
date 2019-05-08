package com.zhaluobox.crazyjava.chapter16.practice.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式 :
 */
public class ThreadDemo3 implements Callable<Integer> {

    private int i = 0;

    @Override
    public Integer call() throws Exception {
        for (; i <15 ; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        return i;
    }


    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new ThreadDemo3());
        new Thread(task,"线程1").start();
        Integer integer = null;
        try {
            integer = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);

    }

}

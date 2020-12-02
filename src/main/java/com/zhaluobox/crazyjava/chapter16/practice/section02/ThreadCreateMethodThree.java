package com.zhaluobox.crazyjava.chapter16.practice.section02;

import java.util.concurrent.*;

/**
 * 线程创建的方式3
 *  1.  实现Callable
 *  2.  重写call方法 有返回值
 *  3.  创建Callable 子类的实例
 *  4.  将Callable 子类的实例传递给 new FutureTask(Callable)
 *  5.  将FutureTask 实例作为参数传给 new Thread(FutureTask task,String name)
 *  6.  start 启动
 */
public class ThreadCreateMethodThree implements Callable<Integer> {

    int i =100;

    @Override
    public Integer call()  {
        while (i > 0) {
                try {
                    i--;
                    System.out.println(Thread.currentThread().getName() + (i > 0 ? (": 余票    " + i + "    张") : (": 已售完")));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        return i;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        final FutureTask<Integer> task = new FutureTask<>(new ThreadCreateMethodThree());
        new Thread(task,"窗口1").start();
        System.out.println("返回值---------------------"+task.get());
    }
}

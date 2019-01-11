package com.zhaluobox.crazyjava.chapter16.section02.practice;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 展示CPU的随机性
 */
public class MyThreadTest1 {

    /**
     * 线程实现方式1 继承Thread 实现多线程
     * 注意 继承Thread是无法共享线程类的资源变量
     */
    @Test
    public void threadTest1() {
        Thread thread1 = new MyThread();
        thread1.setName("线程1");
        Thread thread2 = new MyThread();
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

    /**
     * 多线程实现方式2
     * 假如没有给多线程命名  多线程会以 Thread-0,Thread-1,Thread-2 ... Thread-n持续增长命名
     * <p>
     * 源码参照:
     * public Thread(Runnable target) {
     * init(null, target, "Thread-" + nextThreadNum(), 0);
     * }
     */
    @Test
    public void threadTest2() {

        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        new Thread(runnable1).start();
        new Thread(runnable2, "线程2").start();
        /*
         *   runnable 接口只有一个run抽象方法,在java8 被@FunctionalInterface修饰,也就是说Runnable是一个函数式接口
         *   所以我们也可以用lamdba表达式的形式创建;
         * */
        new Thread(() -> {
            int i = 1;
            for (; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "线程3").start();
    }

    /**
     * 多线程方式3
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void threadTest3() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        Thread thread = new Thread(task, "callable");
        thread.start();
        Integer integer = task.get();
        System.out.println(integer);
    }

    /**
     * 多线程方式3
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void threadTest4() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                sum += i;
            }
            return sum;
        });

        new Thread(task, "线程1").start();
        System.out.println("----------");
        new Thread(task, "线程2").start();
        System.out.println("-------");
        System.out.println(task.get());
    }


}

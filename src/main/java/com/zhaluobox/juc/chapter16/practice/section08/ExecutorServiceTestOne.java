package com.zhaluobox.juc.chapter16.practice.section08;

import java.util.concurrent.*;

class Thread1 implements Runnable {

    int i = 0;
    private Object obj = new Object();

    @Override
    public void run() {
//        synchronized (obj){
            for (; i < 20; i++) {
                System.out.println( Thread.currentThread().getName() + " Runnable : " + i );
                try {
                    Thread.sleep( 100 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        }
    }
}

public class ExecutorServiceTestOne {

    public static void main(String[] args) {
        //1.  使用Excutors的静态工厂方法创建连接池
        //2.  创建Runnable 或者 Callable<T>的实现类
        //3.  使用ExecutorService 的 submit(Runnable/Callable) 方法将线程交给线程池管理
        //4.  当不准备再添加新的线程的时候 调用ExecutorService 的 shutdown() 方法关闭线程池
        final ExecutorService executorService = Executors.newFixedThreadPool( 6 );

        Callable<Integer> target = new Callable<Integer>() {
            int i = 100;
            private Object obj = new Object();
            @Override
            public Integer call() throws Exception {
//                synchronized (obj){
                    for (; i < 150; i++) {
                        System.out.println( Thread.currentThread().getName() + " Callable : " + i );
                        Thread.sleep( 100 );
                    }
                    return i-1;
//                }
            }
        };

        final Thread1 thread1 = new Thread1();
        executorService.submit( thread1 );
        executorService.submit( thread1 );

        final Future<Integer> submit2 = executorService.submit( target );
        final Future<Integer> submit3 = executorService.submit( target );

        executorService.shutdown();

        try {
            System.out.println( submit2.get() );
            System.out.println( submit3.get() );
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

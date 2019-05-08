package com.zhaluobox.crazyjava.chapter16.practice;

/**
 * 多线程实现方式2
 * 注意:
 *      在这里获取线程的名称不能再是this.getName(),而是Thread.currentThread().getName();
 *      这里获取当前线程要使用Thread 的静态方式 currentThread() 方法;
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<100; i++ ){
            System.out.println(Thread.currentThread().getName()+ " - " + i);
        }
    }

    /**
     * 演示后台守护线程
     * @param args
     */
    public static void main(String[] args) {

        // Exception in thread "main" java.lang.IllegalThreadStateException
        // 设置后台线程必须在线程启动之前

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000 ; i++) {
                System.out.println(Thread.currentThread().getName()+": " + i);
            }
        },"t1 后台线程");
        t1.setDaemon(true);
        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+": " + i);
            if(i == 10) {
                new Thread(new MyRunnable(), "子线程").start();
            }
        }
    }
}

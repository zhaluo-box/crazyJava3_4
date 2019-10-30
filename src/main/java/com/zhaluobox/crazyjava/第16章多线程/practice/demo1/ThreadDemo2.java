package com.zhaluobox.crazyjava.第16章多线程.practice.demo1;

/**
 * 实现线程的方式2  实现Runnable
 * <p>
 * 多线程启动 共享实例变量[前提是传入相同的runnable实现类]
 */
public class ThreadDemo2 implements Runnable {

    /**
     * 实例变量
     */
    private int i = 0;

    @Override
    public void run() {
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }


    public static void main(String[] args) {
        ThreadDemo2 th1 = new ThreadDemo2();
        // 两个线程的target 传递的是同一个th1,实例变量被共享
        Thread thread1 = new Thread(th1, "线程1");
        Thread thread2 = new Thread(th1, "线程2");

        thread1.start();
        thread2.start();

        /**
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
}

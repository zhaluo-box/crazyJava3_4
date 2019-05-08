package com.zhaluobox.crazyjava.chapter16.practice.demo1;

/**
 * 创建线程的第一种方式 继承Thread
 */
public class ThreadDemo1 extends Thread{

    /**
     * 类变量
     */
    public static int i = 0;

    /**
     * 示例变量
     */
//    private int i = 0;

    public ThreadDemo1(String name) {
        super(name);
    }

    public ThreadDemo1() {
        super();
    }

    /**
     * run() 方法是线程的执行体,当线程start启动后 执行的就是run()方法
     */
    @Override
    public void run() {
        super.run();
//        int i = 0;
        for (;i < 15 ; i++) {
            System.out.println(getName()+" : "+i);
        }
    }


    /**
     * 实例变量不被共享
     * @param args
     */
    public static void main(String[] args) {

        ThreadDemo1 th1 = new ThreadDemo1();
        th1.setName("线程1");

        ThreadDemo1 th2 = new ThreadDemo1();
        th2.setName("线程2");

        th1.start();
        th2.start();

    }

}

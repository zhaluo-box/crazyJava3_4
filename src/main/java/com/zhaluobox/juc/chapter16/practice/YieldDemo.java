package com.zhaluobox.juc.chapter16.practice;

/**
 * 测试的结果和结论不太一样
 */
public class YieldDemo {

    public static void main(String[] args) {

        Runnable t1 = () -> {
            for (int i = 0; i < 50; i++) {
                //先输出线程
                System.out.println( Thread.currentThread().getName() + " : " + i );
                Thread.yield();

            }
        };

//        for (int i = 0; i < 200; i++) {
//            System.out.println( Thread.currentThread().getName() + "  :  " + i );
//            if (i == 30) {
//                Thread.yield(); // 线程让步
//            }
//        }


        Thread thread1 = new Thread( t1, "高级" );
        Thread thread2 = new Thread( t1, "低级" );

        //Thread thread3 = new Thread(t1, "中级");
        //改变线程优先级
        thread1.setPriority( Thread.MAX_PRIORITY );
        thread2.setPriority( Thread.MIN_PRIORITY );
        //thread3.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();
        //thread3.start();
    }
}

package com.zhaluobox.juc.chapter16.practice;


/**
 * 线程让步Join  测试
 * <p>
 * API: [3种重载的方法]
 * Join()
 * Join(long millis) 让步多少秒
 * Join(long millis,int nanos): 让步多少秒+毫秒 一般不用因为普通的CPU是无法准确到毫秒的;
 * 情景:
 * 一个人 在一边聊天[主线程] 一边吃饭[线程1]
 * 发现菜有点咸了;暂停吃
 * 去喝点饮料[线程2 join 进来];喝完了;
 * 再继续吃菜吃饭;
 * 人的嘴巴相当于CPU 只有一个
 * 吃饭和喝水不能同时进行,所以吃饭让步.喝水进行.喝完了才可以吃;
 */
public class JoinDemo {

    /**
     * 主线程
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread.currentThread().setName( "聊天" );

        /*
         * 子线程1
         */
        Thread eat = new Thread( () -> {
            for (int i = 0; i < 200; i++) {
                System.out.println( Thread.currentThread().getName() + " " + i + "分钟" );
            }
        }, "吃" );
        eat.start();

        for (int i = 0; i < 100; i++) {
            System.out.println( Thread.currentThread().getName() + " : " + i + "分钟" );
            if (i == 30) {
                System.out.println( "++++++++++++++++++++++++++++++++++++++++++++++++" );

                /*
                 * 子线程2  喝豆奶
                 */
                Thread drink = new Thread( () -> {
                    for (int j = 0; j < 100; j++) {
                        System.out.println( Thread.currentThread().getName() + " " + j + "毫升豆奶" );
                    }
                }, "喝" );
                drink.start();

                try {
                    drink.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

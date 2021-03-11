package com.zhaluobox.juc.chapter16.practice;

/**
 * 守护线程 /后台线程示例代码
 *  API:
 *       setDaemon(Boolean b) true设为后台线程 / 默认为 false
 * 情景:
 *     一个人 在吃饭 [主线程]
 *     发现菜有点咸了;暂停吃
 *     去喝点饮料;喝完了;
 *     再继续吃菜吃饭;
 * 但是饭菜在桌子上摆着是一个后台进程.. 从吃饭 - 喝水 - 吃饭 - 吃完 - 下桌[后台结束]
 *  后台线程伴随着当前线程结束而结束
 *
 */
public class DeamonDemo {

    public static void main(String[] args) {
        Thread table = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " 饭菜上了 " + i + " 分钟 ");
            }
        });
        table.setDaemon(true); //设置为后台进程
        table.start();
        Thread eat = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(i == 30){
                    /**
                     * 子线程
                     */
                    Thread drink = new Thread(() -> {
                        for (int j = 0; j < 100; j++) {
                            System.out.println(Thread.currentThread().getName() + " 喝了 " + j + "毫升豆奶");
                        }
                    }, "张三");
                    drink.start();
                    try {
                        drink.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 吃了 " + i + "分钟");
            }
        }, "张三");
        eat.start();

        //---- 到这里吃完了.后台进程也就伴随着停止了
    }

}

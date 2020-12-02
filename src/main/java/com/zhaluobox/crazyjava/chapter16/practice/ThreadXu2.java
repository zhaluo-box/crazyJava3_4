package com.zhaluobox.crazyjava.chapter16.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 同步方法示例
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadXu2 implements Runnable {

    private AccountXu acc;   // 账户
    private double payMoney; // 红包金额
    private long size;       // 个数
    private int sum;         // 计数


    @Override
    public void run() {
        // 标识为 true
        boolean flag = true;
        while (flag) {
            flag = sendRedPackage();
        }
    }

    /**
     * 同步方法
     * 同步方法用到的所有东西都是事先加锁的
     * eg:
     * sum  其实是this.sum  其中this是被枷锁的
     * this.acc 也是
     * Thread.sleep() 方法是不会释放同步监视器的.
     * 一般都是方法执行完毕或者break,return ,exception,error ,代码块/方法执行完毕才会释放同步监视器
     * 其实break,return ,exception,error 都是导致了方法/代码块执行结束
     * 还有一种情况是程序调用了wait()方法;
     *
     * @return
     */
    private synchronized boolean sendRedPackage() {
        if (sum <= size) {
            if (acc.getBalance() >= payMoney) {
                acc.setBalance(acc.getBalance() - payMoney);
                System.out.println("-- (" + sum++ + ")--" + Thread.currentThread().getName() + " 发红包成功,余额为 " + acc.getBalance());
                //    休息片刻.
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                System.out.println("余额不足");
                return false;
            }
        } else {
            System.out.println("红包发放完毕 end ");
            return false;
        }

    }
}

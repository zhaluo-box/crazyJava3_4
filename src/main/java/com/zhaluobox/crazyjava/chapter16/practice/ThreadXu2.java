package com.zhaluobox.crazyjava.chapter16.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadXu2 implements Runnable {

    private AccountXu2 acc;   // 账户
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
     *      同步方法用到的所有东西都是事先加锁的
     *      eg:
     *        sum  其实是this.sum  其中this是被枷锁的
     *        this.acc 也是
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

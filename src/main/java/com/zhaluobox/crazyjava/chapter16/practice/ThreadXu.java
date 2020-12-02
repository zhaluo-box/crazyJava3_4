package com.zhaluobox.crazyjava.chapter16.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自动发钱多线程
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadXu implements Runnable {

    private AccountXu acc;   // 账户
    private double payMoney; // 红包金额
    private long size;       // 个数
    private int sum;         // 计数

    @Override
    public void run() {
        while (true) {
            //同步锁是操作的 公共资源
            synchronized (acc) {
                if (sum <= size) {
                    if (acc.getBalance() >= payMoney) {
                        acc.setBalance(acc.getBalance() - payMoney);
                        System.out.println("-- (" + sum++ + ")--" + Thread.currentThread().getName() + " 发红包成功,余额为 " + acc.getBalance());
                    } else {
                        System.out.println("余额不足");
                        return;
                    }
                    // 休息片刻.
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    return;
                }
            }
        }
    }


}

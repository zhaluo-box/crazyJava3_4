package com.zhaluobox.crazyjava.chapter16.practice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountXu2 {

    private String accountNo;
    private double balance;

    /**
     * 从写equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountXu2 that = (AccountXu2) o;
        return Double.compare(that.balance, balance) == 0 &&
                Objects.equals(accountNo, that.accountNo);
    }

    /**
     * 从写hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {

        return Objects.hash(accountNo, balance);
    }

    public synchronized boolean sendRedPackage(long size, double payMoney, int sum) {
        if (sum <= size) {
            if (this.getBalance() > payMoney) {
                this.setBalance(this.getBalance() - payMoney);
                System.out.println("-- (" + sum++ + ")--" + Thread.currentThread().getName() + " 发红包成功,余额为 " + this.getBalance());
                // 休息片刻.
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                System.out.println("余额不足");
                return false;
            }
        } else {
            return false;
        }
    }
}
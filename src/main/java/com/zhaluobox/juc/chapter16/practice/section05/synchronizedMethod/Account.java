package com.zhaluobox.juc.chapter16.practice.section05.synchronizedMethod;

public class Account {
    // 封装账户编号、账户余额两个成员变量
    private String accountNo;
    private double balance;

    public Account() {
    }

    // 构造器
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // accountNo的setter和getter方法
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    // 因此账户余额不允许随便修改，所以只为balance提供getter方法，
    public double getBalance() {
        return this.balance;
    }

    // 提供一个线程安全draw()方法来完成取钱操作

    /**
     * 同步方法: 对于同步方法而言.锁的对象就是其本身this
     * 对于同一个account而言.只有一个线程可以获取它的draw方法,因为account对象被锁定了
     * @param drawAmount
     */
    public synchronized void draw(double drawAmount) {
        // 账户余额大于取钱数目
        if (balance >= drawAmount) {
            // 吐出钞票
            System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票:" + drawAmount);

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // 修改余额
            balance -= drawAmount;
            System.out.println("\t余额为: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
        }
    }


    // 下面两个方法根据accountNo来重写hashCode()和equals()方法
    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}

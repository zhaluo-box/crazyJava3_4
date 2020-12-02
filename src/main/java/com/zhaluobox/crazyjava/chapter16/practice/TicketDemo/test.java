package com.zhaluobox.crazyjava.chapter16.practice.TicketDemo;


public class test {

    public static void main(String[] args) {
        //创建公共的线程对象
        TicketThread tt = new TicketThread();

        Thread t = new Thread(tt);
        t.setName("窗口1");
        Thread t2 = new Thread(tt);
        t2.setName("窗口2");
        Thread t3 = new Thread(tt);
        t3.setName("窗口3");

        //启动线程对象
        t.start();
        t2.start();
        t3.start();
    }
}

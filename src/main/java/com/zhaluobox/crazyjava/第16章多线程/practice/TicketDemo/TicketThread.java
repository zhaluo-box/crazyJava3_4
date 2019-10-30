package com.zhaluobox.crazyjava.第16章多线程.practice.TicketDemo;

public class TicketThread implements Runnable {

    int tickets = 1000;//火车票数量
    Object obj = new Object();

    @Override
    public void run() {
        //出售火车票
        while (true) {
            synchronized (obj){
                //当火车票小于0张，则停止售票
                if (tickets > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + tickets--);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}

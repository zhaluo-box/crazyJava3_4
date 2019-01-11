package com.zhaluobox.crazyjava.chapter16.practice;

public class TicketThread implements Runnable {

    int tickets = 100;//火车票数量
    Object obj = new Object();

    @Override
    public void run() {
        //出售火车票
        while (true) {
            synchronized (obj){
                //当火车票小于0张，则停止售票
                if (tickets > 0) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + tickets--);
                }
            }

        }
    }

}

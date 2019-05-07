package com.zhaluobox.crazyjava.chapter06.section06;

public class Zhangsan implements Person {

    @Override
    public void eat() {
        System.out.println("张三也吃五谷杂粮");
    }

    @Override
    public void drink() {
        System.out.println("张三平时和红牛");
    }

    /**
     * 默认方法可以重写.
     */
    //    @Override
//    public void say() {
//        System.out.println("每天吹吹牛皮,才是人生的乐事,认真你就输了");
//    }

    /**
     * 张三的一生
     */
    public void experience(){
        lifeAndDeath lifeAndDeath = new lifeAndDeathImpl();
        lifeAndDeath.life();
        lifeAndDeath.death();
    }

    class lifeAndDeathImpl implements lifeAndDeath{

        @Override
        public void life() {
            System.out.println("张三:出身于中产阶级");
        }

        @Override
        public void death() {
            System.out.println("张三:努力一辈子,晚年病魔压身,70而卒");
        }
    }

}

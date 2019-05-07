package com.zhaluobox.crazyjava.chapter06.section06;

public class Lisi implements Person {

    @Override
    public void eat() {
        System.out.println("李四也吃五谷杂粮");
    }

    @Override
    public void drink() {
        System.out.println("李四平时和红牛");
    }

    @Override
    public void say() {
        System.out.print("默认方法重写---");
        System.out.println("李四: 我讲真话别人都以为我是吹牛皮");
    }

    /**
     * 张三的一生
     */
    public void experience(){
        lifeAndDeath lifeAndDeath = new deathAndLifeImpl();
        lifeAndDeath.life();
        lifeAndDeath.death();
    }
    /**
     * 先实现接口,内部类才能实现内部接口
     */
    class deathAndLifeImpl implements lifeAndDeath{

        @Override
        public void life() {
            System.out.println("李四: 出生于豪门");
        }

        @Override
        public void death() {
            System.out.println("李四: 吃喝玩乐活到99");
        }
    }
}

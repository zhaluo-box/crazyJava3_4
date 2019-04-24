package com.zhaluobox.designMode.factorymode2;

/**
 * 工厂演示
 *
 */
public class HumanFactoryDemo {

    public static void main(String[] args) {
        Human human = HumanFactory.createHuman(BlackHuman.class);
        human.cry();
        System.out.println(BlackHuman.class.getName());
    }
}

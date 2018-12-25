package com.zhaluobox.crazyjava.chapter06.section07;


/**
 * 接口
 */
interface Animal {

    void eat();
}

/**
 * 抽象类
 */
abstract class Cat {

    abstract String getName();

}

abstract class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    abstract void eat();
}

/**
 * 演示匿名内部类
 * 其实匿名内部类的存在就是简化java代码.少写一些只用一次的类;
 * 而且匿名内部类在你创建了实例之后.它就消失了; 你只能在你创建实例的地方使用.在其他地方就得不到它了;
 */
public class AnonymousInnerDemo {

    public static void main(String[] args) {

        /*
         * 这个Animal 接口 我只用一次.就可以直接使用匿名内部类去实现它.创建它的实例;
         *
         * 而不是专门去写个类去实现它.然后再注入到这个类中[或者new 实现类的实例]
         *
         */
        /**
         *  匿名内部类的语法1 new 一个接口的实例
         */
        Animal animal = new Animal() {

            @Override
            public void eat() {
                System.out.println("------人为财死,鸟为食亡------");
            }
        };

        animal.eat();


        /*
         * 猫有很多很多种.猫除了名字,习性行为基本都一样,我们不可能每一个都去写一个类
         *
         * 所以我们就使用匿名内部类,
         *     狸花猫我只用一次,
         *     而不是再去写个狸猫的类去继承cat
         */
        /**
         *  匿名内部类的语法1 new 一个抽象类的实例
         */
        Cat cat = new Cat() {

            @Override
            String getName() {
                return "狸猫";
            }
        };

        System.out.println(cat.getName() + "换太子");


        /**
         * java 8 对匿名内部类有了改变.在JDK 8 以前匿名内部类传入的局部变量必须由final修饰.
         * JDK8 以后就可以省略final修饰符
         * 但是 省略了并不代表就和其他局部变量一样了.传入的这个局部变量依旧要遵守final修饰的规则;
         * 假如我们再给age赋值就会报错;
         *          其实我们不加final JDK8 在编译的时候默认还是用了final修饰的;
         */
        //final String  name = "萨摩耶";
        int  age = 23;
        String  name = "萨摩耶";
        Dog dog = new Dog(name) {


            @Override
            void eat() {
                name = "998"; // 但是通过构造传过来的依旧是没问题的;
                System.out.println("萨摩耶爱吃皇家狗粮");
                System.out.println(age);
               // age =3; 编译出错 被匿名内部类访问就相当于被final 修饰
            }
        };

        dog.eat();

        /*
         * 总结一下:
         *          匿名内部类的存在.让我们原本需要写一个类 extends 、 implements ;
         *          然后再到指定类里面new出来,再调用方法达到我们的需求.
         *      --->
         *          变得只需要创建一个匿名内部类然后调用方法达到我们的需求
         *
         *   总结的怪怪的希望大家能看懂
         */

    }

}

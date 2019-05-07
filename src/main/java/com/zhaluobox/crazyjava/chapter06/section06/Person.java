package com.zhaluobox.crazyjava.chapter06.section06;

/**
 * 人
 *
 * @author 扎罗
 */
public interface Person {

    /**
     * 最小年龄
     */
    public static final Integer minAge=0;

    /**
     * 高龄
     */
    public static final Integer advancedAge=100;


    /**
     * 吃
     */
    public abstract  void  eat();

    /**
     * 喝
     */
    public abstract  void  drink();


    /**
     * JDK8 新增的默认方法
     */
    default void say(){
        System.out.println("从牙牙学语,到人老成精");
    }

    /**
     * JDK8 新增的类方法
     */
    public static void  aphorism(){
        System.out.println("生老病死是人之常态");
    }

//    /**
//     * JDK9 新增的私有方法.
//     */
//    private void privateMethod(){
//
//    }

    /**
     * 内部枚举,
     */
    enum ageEnum{

        /**
         * 幼儿
         */
        NFANT,
        /**
         * 儿童
         */
        CHILD,
        /**
         * 青年
         */
        YOUNG,
        /**
         * 中年
         */
        WRINKLY,
        /**
         * 老年
         */
        OLDPERPLE;

    }

    /**
     * 内部接口
     */
    interface lifeAndDeath{
        /**
         * 生
         */
        void life();

        /**
         * 死
         */
        void death();
    }
}

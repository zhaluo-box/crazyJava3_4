package com.zhaluobox.crazyjava.chapter06.section08;


/**
 * Description:函数式接口，使用@FunctionalInterface,
 * 编译器执行更严格的检查
 * Lambda表示的结果就被当做队形，因此程序中完全可以使用lambda表达式进行赋值。
 */
@FunctionalInterface
interface FkTest {
    void run();
}

public class LambdaTest05 {
    public static void main(String[] args) {
        // Runnable接口中只包含一个无参数的方法
        // Lambda表达式代表的匿名方法实现了Runnable接口中唯一的、无参数的方法
        // 因此下面的Lambda表达式创建了一个Runnable对象
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        };

        // 匿名内部类的写法
        Runnable rr = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println();
                }
            }
        };

//		// 下面代码报错: 不兼容的类型: Object不是函数接口
//		Object obj = () -> {
//			for(int i = 0 ; i < 100 ; i ++)
//			{
//				System.out.println();
//			}
//		};

        Object obj1 = (Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        };

        // 同样的Lambda表达式可以被当成不同的目标类型，唯一的要求是：
        // Lambda表达式的形参列表与函数式接口中唯一的抽象方法的形参列表相同
        Object obj2 = (FkTest) () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        };

    }
}

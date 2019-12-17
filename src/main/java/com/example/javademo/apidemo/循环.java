package com.example.javademo.apidemo;

public class 循环 {

    public static void main(String[] args) {




    }

    /**
     * return 跳出方法测试
     *  return 直接结束方法.跟着循环也就结束
     *      无论循环有多少层都无意义
     */
    private static void returnDemo() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("计数器"+ ++count);

            for (int j = 0; j < 5; j++) {

                for (int k = 0; k < 3; k++) {
                    System.out.println("最外层" + i + "--中间--" + j + "---内部---" + k);
                    if (k == 1) {
                        return;
                    }
                }
            }
        }
    }

    /**
     * 循环示例
     * 跳出多层循环
     * 关键点: 循环标识符
     */
    private static void forDemo() {
        oouter:
        for (int i = 0; i < 10; i++) {
            System.out.println("---=========hahahahahaaa=--------------");
            outer:
            //外层循环标识要放在外层循环外
            for (int K = 0; K < 10; K++) {

                for (int j = 0; j < 5; j++) {
                    System.out.println("--------------------------------------------");
                    System.out.println();
                    System.out.println("==索引==" + i);
                    System.out.println("索引+++++" + j);
                    if (j == 1) {
                        System.out.println("跳出循环");
                        break oouter;
                    }
                }
            }

        }
    }
}

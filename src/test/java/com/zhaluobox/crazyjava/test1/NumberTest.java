package com.zhaluobox.crazyjava.test1;

import org.junit.Test;

public class NumberTest {

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
//            System.out.println(i / 5);
        }
    }
}

package com.zhaluobox.crazyjava.chapter5;

import org.junit.Test;

public class ContructorTest {

    /**
     * 测试提供了有参构造 JVM是否会为我们提供一个无参构造;
     * 实际编译器会报错 无法通过.提示你有了有参需要增加一个无参,或者添加参数
     */
    @Test
    public void testControctor(){
        final User user = new User();

        System.out.println(user);
    }
}

package com.zhaluobox.crazyjava.chapter15.mytest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemoTest {

    @Before
    public void setUp() throws Exception {
    }

    /**
     * void write(String str):写一个字符串数据
     * void write(String str,int index,int len):写一个字符串中的一部分数据
     * void write(int ch):写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',97
     * void write(char[] chs):写一个字符数组数据
     * void write(char[] chs,int index,int len):写一个字符数组的一部分数据
     * @throws IOException
     */
    @Test
    public  void test1() throws IOException {
        File file = new File("a.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("你们好啊",0,3);
        fw.flush();
        fw.close();
    }


    @After
    public void tearDown() throws Exception {

    }
}

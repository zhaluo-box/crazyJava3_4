package com.example.javademo.ieter;

public class ForDemo {

    public static void main(String[] args) {
        int i = 0;
        for (; ; ) {
            System.out.println( i++ );
            if (i > 100)  break;
        }
    }
}

package com.zhaluobox.crazyjava.chapter06.practice;

public class TestEXception {
    public static void main(String[] args) {

//        try {
//            int i = 1/0;
//            System.out.println("121121");
//        }catch (Exception e){
//            System.out.println(1);
//        }
//        System.out.println("111111111111122222222222");

        String s = "a;d;c;d;d;ccc;";
        final String[] strings = s.split( ";" );

        for (String string : strings) {
            System.out.println("字母 :  1"+string+"1 ");
        }

    }
}

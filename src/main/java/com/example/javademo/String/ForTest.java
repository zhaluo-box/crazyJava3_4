package com.example.javademo.String;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForTest {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put( "tb", "111" );
        map.put( "b2b", "222" );
        map.put( "b2c", "333" );
        map.put( "app", "444" );
        map.put( "kj", "555" );

        String merchantName = "";
        map.forEach( (k, v) -> {
            if (StringUtils.isNotBlank( merchantName )
                    && !k.equalsIgnoreCase( merchantName )) {
                return;
            }
            System.out.println( k );
        } );


        System.out.println( "c-------------------" );

        //lamada表达式中foreach使用break
        List<String> c = Arrays.asList( "6666", "7777", "8888", "9999" );
        c.stream().forEach( str -> {
            if ("8888".equals( str )) {
                return; //跳出当前循环,继续下一轮
            }
            System.out.println( str );

        } );

        c.forEach( k -> {
            if ("8888".equals( k )) {
                return; //跳出当前循环,继续下一轮
            }
            System.out.println( k );
        } );

        System.out.println( "d-------------------" );

        //        List<String> d = Arrays.asList( "6666", "7777", "8888", "9999" );
        //        d.stream().forEach( str -> {
        //            System.out.println( str );
        //            if ("8888".equals( str )) {
        //                break; //IDE提示错误:break cannot be used outside of a loop or a switch
        //            }
        //
        //        } );
        //        System.out.println( "a-------------------" );
        //        List<String> a = new ArrayList<>();
        //        a.add( "1111" );
        //        a.add( "2222" );
        //        a.add( "3333" );
        //        a.add( "4444" );
        //        for (String str : a) {
        //            if ("3333".equals( str )) {
        //                break;   //正常跳出循环
        //            }
        //            System.out.println( str );
        //        }
        //
        //        System.out.println( "b-------------------" );
        //
        //        List<String> b = new ArrayList<>();
        //        b.add( "1111" );
        //        b.add( "2222" );
        //        b.add( "3333" );
        //        b.add( "4444" );
        //        for (String str : b) {
        //            if ("3333".equals( str )) {
        //                return; //也能跳出循环
        //            }
        //            System.out.println( str );
        //        }

    }

}


package com.example.javademo.String;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StringTest1 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add( i + "" );
        }

        //'交易退款'== COLUMN11  ? 'R' : ('在线支付'== COLUMN11  ? 'S' : '')
        for (int i = 20200301; i < 20200328; i++) {
            String date1 = i + "";
            String date2 = (i + 1) + "";
            String src1 = File.separator + date1;
            System.out.println( src1 );
            System.out.println(date1);
            System.out.println(date2);

            loop2:
            for (String s : list) {
                if (s.equals( "6" )) {
                    System.out.println( s );
                    // break loop2;
                    break loop2;
                }
            }
            //                @SuppressWarnings("unchecked")
            //                Vector<LsEntry> ls1 = yun.ls(src1);
            //                for (LsEntry entry : ls1) {
            //                    String filename = entry.getFilename();
            //                    if (filename.startsWith("451111912160001_" + date1 + "_" + date2)) {
            //                        yun.get(src + File.separator + filename, desc);
            //                        log.info("云闪付01新文件下载成功: {}", filename);
            //                        break;
            //                    }
            //                }
        }

        //  stringConverChars( "abcdddd" );
    }

    public static void stringConverChars(String str) {
        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println( chars[i] );
        }
        //        Stream<Character> ch = Arrays.stream( chars );
        int[] arr = new int[]{1, 2, 3, 4};
        final IntStream stream = Arrays.stream( arr );
        stream.forEach( System.out::println );

    }


}

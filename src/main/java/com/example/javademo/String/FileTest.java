package com.example.javademo.String;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        final File file = new File( "C:\\home\\appadm\\paxc\\ftp\\download\\ORAS\\autoImportRenameDoc\\ARM\\payment\\unionpay\\yun01\\451111912160001_20200310_20200311065001_1_1.txt" );

        String fileType = returnFlagFolderName(file);
        System.out.println(fileType);
    }

    public static String returnFlagFolderName(File file) {
        if (file == null) {
            return null;
        }

        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return null;
        }
        if (("payment".equals(parentFile.getName())) && file.isDirectory()) {
            return file.getName();
        }
//        Boolean flag = ("yun01".equals(file.getName()) && file.isDirectory())
//                || (("payment".equals(parentFile.getName())) && file.isDirectory());
//        if (flag) {
//            return file.getName();
//        }
        return returnFlagFolderName(parentFile);
    }
}

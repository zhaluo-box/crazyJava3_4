package com.zhaluobox.crazyjava.chapter15;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;

public class StringTest {

    @Test
    public void test1() {
        String filePath = "/oras/paxc/ftp/download/ORAS-3U/autoImportDoc/ARM/payment/huifu/a//oras/paxc/ftp/download/ORAS-3U/autoImportDoc/ARM/payment/huifu/a/20170909.zip";
        File file = new File(filePath);
        System.out.println(file.getName());
        //替换掉自动导入保存路径
        String mmmm = filePath.replace("/oras/paxc/ftp/download/ORAS-3U/autoImportDoc/", "");
        // 自动支付商数据各自要导入的中间目录
        System.out.println(File.separator);
        String midPath = mmmm.substring(0, mmmm.lastIndexOf("/"));
        String fileName = file.getName().split("\\.")[0];
        System.out.println(fileName);
    }




    public static String getExtName(String filePathAndName) {
        String extName = "";
        if (StringUtils.isNotEmpty(filePathAndName)) {
            int index = filePathAndName.lastIndexOf(".");
            if (index > -1) {
                extName = filePathAndName.substring(index + 1);
            }
        }
        return extName;
    }

    public static void main(String[] args) {

        String a = "C:\\home\\appadm\\paxc\\ftp\\download\\ORAS\\autoImportDoc\\autoAlipay\\abc.zip";

        System.out.println( getExtName( a ) );
    }
}

package com.example.javademo.zip;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

@Slf4j
public class UnZipFiles {

    private static void unzip() {
        try {
            ZipFile zipFile = new ZipFile( "C:\\home\\appadm\\paxc\\ftp\\download\\ORAS\\autoImportDoc\\autoAlipay\\淘宝旗舰店_A_20200220_20200220.zip" );
            zipFile.setFileNameCharset( "GBK" );
            zipFile.extractAll( "D:\\test" );
            final File file = new File( "D:\\test" );
            final File[] files = file.listFiles();
            if (null != files && files.length > 0) {
                for (File file1 : files)
                    if (!file1.getName().endsWith( "_账务明细.csv" )) {
                        if (file1.delete()) {
                            log.info( "{} : 文件已删除!", file1.getName() );
                        }
                    }
            }
            // 如果解压需要密码
            //            if(zipFile.isEncrypted()) {
            //                zipFile.setPassword("111");
            //            }
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unzip();
    }
}

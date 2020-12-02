package com.zhaluobox.crazyjava.chapter15.mytest;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class FeileRenameto {

    public static void main(String[] args) {
        final File file= new File( "D:\\downalipay\\支付宝无线_A_20200217_20200217.zip" );
        final File file1= new File( "D:\\downalipay\\ABC\\支付宝无线_A_20200217_20200217.zip" );
        if (!file.exists()) {
            // 获取父文件目录
            final File parentFile = file.getParentFile();
            // 如果父文件不存在.则新建
            if (!parentFile.exists()) {
                if (parentFile.mkdirs()) {
                    log.debug( "父文件目录创建成果" );
                }
                log.debug( "文件不存在!" );
            }
        }
        if (file.exists()) {
            if (file.renameTo( file1 )) {
                log.info( "文件移动成功" );
            } else {
                log.debug( "文件移动失败" );
            }
        }

    }
}

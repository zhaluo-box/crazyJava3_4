package com.example.javademo.sftp;


import com.jcraft.jsch.SftpProgressMonitor;

/**
 * 自己实现的进度监控.
 */
public class MyProgressMonitor implements SftpProgressMonitor {
    private long transfered;

    @Override
    public boolean count(long count) {
        transfered = transfered + count;
        System.out.println( "Currently transferred total size: " + transfered + " bytes" );
        return true;
    }

    @Override
    public void end() {
        System.out.println( "Transferring done." );
    }

    @Override
    public void init(int op, String src, String dest, long max) {
        System.out.println( "Transferring begin." );
    }
}

package com.zhaluobox.juc.chapter16.practice.section08;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceTestTwo {
    public static void main(String[] args) {
        final ScheduledExecutorService pool = Executors.newScheduledThreadPool( 10 );

    }
}

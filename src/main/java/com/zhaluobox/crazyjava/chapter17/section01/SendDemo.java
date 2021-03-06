package com.zhaluobox.crazyjava.chapter17.section01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 创建发送端Socket对象
 * 		创建数据并打包
 * 		发送数据
 * 		释放资源
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();
        //创建数据并打包
		/*
		 * DatagramPacket :此类表示数据报包
		 * 数据 byte[]
		 * 设备的地址 ip
		 * 进程的地址  端口号
		   DatagramPacket(byte[] buf, int length, InetAddress address, int port)
		 */
        String s = "hello UDP 协议";
        byte[] bys = s.getBytes();
        int length = bys.length;
        // 指定发送地址
        InetAddress address = InetAddress.getByName("172.24.107.220");//发送给当前设备
        int port = 8888;
        //打包
        DatagramPacket dp = new DatagramPacket(bys, length, address, port);
        //发送数据
        ds.send(dp);
        //释放资源
        ds.close();
    }
}

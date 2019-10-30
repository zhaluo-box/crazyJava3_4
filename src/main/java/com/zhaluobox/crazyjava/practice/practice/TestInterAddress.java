package com.zhaluobox.crazyjava.practice.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestInterAddress {

    public static void main(String[] args) throws IOException {
        int i = 0;
        int s = 0;
        for (int j = 0; j <100 ; j++) {

            URL urlObj = new URL("https://www.baidu.com/s?ie=UTF-8&wd=win%2010%20%E5%AE%89%E8%A3%85%E7%9A%84%E5%9D%8E%E5%9D%B7%E4%B9%8B%E8%B7%AF");
            HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
            oc.setUseCaches(false);
            oc.setConnectTimeout(3000); // 设置超时时间
            int status = oc.getResponseCode();// 请求状态
            if (status != 200) {
                System.out.println(i++);
            } else {
                System.out.println("success" + s++);
            }
            oc.disconnect();
        }
    }
}

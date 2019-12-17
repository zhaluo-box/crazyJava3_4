package com.example.javademo.entity;

import com.example.javademo.oriented.interfaceLearn.OutPut;
import com.example.javademo.oriented.interfaceLearn.Product;
import lombok.extern.slf4j.Slf4j;

/**
 * 接口实现类测试
 *
 */
@Slf4j
public  class InterfaceImpl implements OutPut, Product {

    @Override
    public void out() {
        log.info("多实现,实现所有方法");
    }

    @Override
    public Integer getProductTime() {
        return 99999;
    }

    @Override
    public void start() {
        log.info("run---------------");
    }

    public static void main(String[] args) {

        /**
         * 实现接口的同时.继承了接口中的常量
         */
        log.info(MAX_CACHE_LINE+"");

        InterfaceImpl anInterface = new InterfaceImpl();
        log.info("=======默认方法===run");
        anInterface.run();
        log.info("=========start");
        anInterface.start();
        log.info("=========getproduct");
        anInterface.getProductTime();
        log.info("=========out");
        anInterface.out();


    }
}

package com.zhaluobox.designMode.strategy.demo1;

/**
 * 具体的策略实现2
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println( " 具体的策略实现2  " );
    }
}

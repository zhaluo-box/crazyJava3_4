package com.zhaluobox.designMode.strategy.demo2.strategy;


import java.util.Map;

/**
 * 缓存淘汰策略接口.
 */
public interface EvictionStrategy {

    void replacement(Map<? extends Object, ? extends Object> cacheData);

}

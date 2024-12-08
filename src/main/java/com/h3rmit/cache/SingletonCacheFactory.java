package com.h3rmit.cache;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.cachingtypes.impl.DatabaseCache;
import com.h3rmit.cache.cachingtypes.impl.HashMapCache;

public class SingletonCacheFactory {

    private static volatile SingletonCacheFactory instance;

    private SingletonCacheFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static SingletonCacheFactory getInstance() {
        if (instance == null) {
            synchronized(SingletonCacheFactory.class) {
                if (instance == null) {
                    instance = new SingletonCacheFactory();
                }
            }
        }
        return instance;
    }

    public Cache getCacheInstance(CacheConfig config) {
        Cache cache = null;
        switch (config.cacheType()) {
            case DATABASE:
                cache = new DatabaseCache(config.evictionPolicyList());
                break;
            default:
                cache = new HashMapCache(config.evictionPolicyList());
        }
        return cache;
    }
}

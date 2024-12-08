package com.h3rmit.cache;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.cachingtypes.impl.DatabaseCache;
import com.h3rmit.cache.cachingtypes.impl.HashMapCache;

public class SingletonCacheFactory<K, V> {

    @SuppressWarnings("rawtypes")
    private static volatile SingletonCacheFactory instance;

    private SingletonCacheFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    @SuppressWarnings("rawtypes")
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

    public Cache<K, V> getCacheInstance(CacheConfig<K, V> config) {
        Cache<K, V> cache = null;
        switch (config.cacheType()) {
            case DATABASE:
                cache = new DatabaseCache<K, V>(config.evictionPolicyList());
                break;
            default:
                cache = new HashMapCache<K, V>(config.evictionPolicyList());
        }
        return cache;
    }
}

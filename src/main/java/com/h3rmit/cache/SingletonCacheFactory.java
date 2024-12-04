package com.h3rmit.cache;

import com.h3rmit.cache.type.Cache;
import com.h3rmit.cache.enums.CacheType;
import com.h3rmit.cache.type.impl.DatabaseCache;
import com.h3rmit.cache.type.impl.HashMapCache;

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

    public Cache getCacheInstance(CacheType type) {
        Cache cache = null;
        switch (type) {
            case DATABASE:
                cache = new DatabaseCache();
                break;
            default:
                cache = new HashMapCache();
        }
        return cache;
    }
}

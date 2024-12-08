package com.h3rmit.cache;

import java.util.HashMap;
import java.util.Map;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.enums.CacheType;

public class CacheManagerImpl implements CacheManager {
    private final Map<CacheType, Cache> cacheStore;
    private final SingletonCacheFactory cacheFactory;

    private CacheManagerImpl(SingletonCacheFactory cacheFactory) {
        cacheStore = new HashMap<>();
        this.cacheFactory = cacheFactory;
    }

    @Override
    public Cache getCacheInstance(CacheConfig cacheConfig) {
        if (cacheStore.keySet().contains(cacheConfig.cacheType())) {
            return cacheStore.get(cacheConfig.cacheType());
        }
        cacheStore.put(cacheConfig.cacheType(), cacheFactory.getCacheInstance(cacheConfig));
        return cacheStore.get(cacheConfig.cacheType());
    }

    @Override
    public void destroyCache(CacheType cacheType) {
        cacheStore.remove(cacheType);
    }
    
}

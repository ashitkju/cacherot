package com.h3rmit.cache;

import java.util.HashMap;
import java.util.Map;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.enums.CacheType;

public class CacheManagerImpl<K, V> implements CacheManager<K, V> {
    private final Map<CacheType, Cache<K, V>> cacheStore;
    @SuppressWarnings("rawtypes")
    private final SingletonCacheFactory cacheFactory;

    private CacheManagerImpl(@SuppressWarnings("rawtypes") SingletonCacheFactory cacheFactory) {
        cacheStore = new HashMap<>();
        this.cacheFactory = cacheFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Cache<K, V> getCacheInstance(CacheConfig<K, V> cacheConfig) {
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

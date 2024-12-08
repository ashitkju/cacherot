package com.h3rmit.cache;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.enums.CacheType;

public interface CacheManager<K, V> {
    Cache<K, V> getCacheInstance(CacheConfig<K, V> cacheConfig);
    void destroyCache(CacheType cacheType);
}

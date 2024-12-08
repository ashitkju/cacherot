package com.h3rmit.cache;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.enums.CacheType;

public interface CacheManager {
    Cache getCacheInstance(CacheConfig cacheConfig);
    void destroyCache(CacheType cacheType);
}

package com.h3rmit.cache.eviction;

import java.util.List;

import com.h3rmit.cache.eviction.dto.EvictData;

public interface EvictionPolicy<K, V> {
    public List<K> evict(EvictData<K, V> evictData);
}

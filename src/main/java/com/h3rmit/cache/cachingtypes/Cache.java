package com.h3rmit.cache.cachingtypes;

import com.h3rmit.cache.eviction.dto.EvictData;

public interface Cache<K, V> {
    V get(K key);
    K put(K key, V value);
    K remove(K key);
    void evict(EvictData<K, V> evictData);
}

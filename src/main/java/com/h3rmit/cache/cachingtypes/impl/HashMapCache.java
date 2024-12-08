package com.h3rmit.cache.cachingtypes.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.eviction.EvictionPolicy;
import com.h3rmit.cache.eviction.dto.EvictData;
import com.h3rmit.cache.eviction.enums.EvictOnOperation;

public class HashMapCache<K, V> implements Cache<K, V> {

    private final List<EvictionPolicy<K, V>> evictionPolicyList;
    private final Map<K, V> cacheMap;

    public HashMapCache(List<EvictionPolicy<K, V>> evictionPolicyList) {
        this.evictionPolicyList = evictionPolicyList;
        this.cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public V get(K key) {
        evict(new EvictData<K, V>(EvictOnOperation.GET, key, null));
        return cacheMap.get(key);
    }

    @Override
    public K put(K key, V value) {
        evict(new EvictData<K, V>(EvictOnOperation.PUT, key, value));
        cacheMap.put(key, value);
        return key;
    }

    @Override
    public K remove(K key) {
        evict(new EvictData<K, V>(EvictOnOperation.REM, key, null));
        var value = cacheMap.remove(key);
        return value != null ? key : null;
    }

    @Override
    public void evict(EvictData<K, V> evictData) {
        evictionPolicyList.forEach(eviction -> eviction.evict(evictData));
    }
    
}

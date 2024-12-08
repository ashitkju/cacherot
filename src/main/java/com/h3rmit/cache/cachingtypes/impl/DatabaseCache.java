package com.h3rmit.cache.cachingtypes.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.h3rmit.cache.cachingtypes.Cache;
import com.h3rmit.cache.eviction.EvictionPolicy;
import com.h3rmit.cache.eviction.dto.EvictData;

public class DatabaseCache<K, V> implements Cache<K, V> {
    
    private final List<EvictionPolicy<K, V>> evictionPolicyList;
    private final Map<K, V> cacheMap;
 
    public DatabaseCache(List<EvictionPolicy<K, V>> evictionPolicyList) {
        this.evictionPolicyList = evictionPolicyList;
        this.cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public K put(K key, V value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public K remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void evict(EvictData<K, V> evictData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evict'");
    }
    
}

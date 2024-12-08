package com.h3rmit.cache.eviction.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.h3rmit.cache.eviction.EvictionPolicy;
import com.h3rmit.cache.eviction.dto.EvictData;

public class LRUEvictionPolicy<K, V> implements EvictionPolicy<K, V> {
    private final long capacity;
    private final Deque<K> queue;

    public LRUEvictionPolicy(long capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>();
    }

    @Override
    public List<K> evict(EvictData<K, V> evictData) {        
        List<K> keysToBeRemoved = new ArrayList<>();
        if (queue.size() == capacity) {
            keysToBeRemoved.add(queue.pop());
        }
        return keysToBeRemoved;
    }
    
}

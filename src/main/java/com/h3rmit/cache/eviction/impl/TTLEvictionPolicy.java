package com.h3rmit.cache.eviction.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.h3rmit.cache.eviction.EvictionPolicy;
import com.h3rmit.cache.eviction.dto.EvictData;

public class TTLEvictionPolicy<K, V> implements EvictionPolicy<K, V> {
    private final Map<K, Long> ttlMap;
    private final long ttl;

    /**
     * 
     * @param ttl in milliseconds
     */
    public TTLEvictionPolicy(long ttl) {
        this.ttlMap = new HashMap<>();
        this.ttl = ttl;
    }

    @Override
    public List<K> evict(EvictData<K, V> evictData) {
        switch (evictData.evictOnOperation()) {
            case GET:
                if (ttlMap.containsKey(evictData.key())) {
                    ttlMap.put(evictData.key(), System.currentTimeMillis() + ttl);
                }
                break;
            case PUT:
                ttlMap.put(evictData.key(), System.currentTimeMillis() + ttl);
                break;
            case REM:
                ttlMap.remove(evictData.key());
                break;
        }
        return applyTTLCacheClearance();
    }
        
    private List<K> applyTTLCacheClearance() {
        long currentTimeMillis = System.currentTimeMillis();
        List<K> keysToBeRemoved = new ArrayList<>();
        Iterator<Map.Entry<K, Long>> iterator = ttlMap.entrySet().iterator();

        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() > currentTimeMillis) {
                keysToBeRemoved.add(entry.getKey());
                iterator.remove();
            }
        }

        return keysToBeRemoved;
    }

}

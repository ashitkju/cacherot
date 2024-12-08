package com.h3rmit.cache.eviction.dto;

import com.h3rmit.cache.eviction.enums.EvictOnOperation;

public record EvictData<K, V>(EvictOnOperation evictOnOperation, K key, V value) {}

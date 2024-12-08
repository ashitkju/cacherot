package com.h3rmit.cache;

import java.util.List;

import com.h3rmit.cache.enums.CacheType;
import com.h3rmit.cache.eviction.EvictionPolicy;

public record CacheConfig<K, V>(CacheType cacheType, List<EvictionPolicy<K, V>> evictionPolicyList) {}
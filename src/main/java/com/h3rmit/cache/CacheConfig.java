package com.h3rmit.cache;

import java.util.List;

import com.h3rmit.cache.enums.CacheType;
import com.h3rmit.cache.eviction.EvictionPolicy;

public record CacheConfig(CacheType cacheType, List<EvictionPolicy> evictionPolicyList) {}
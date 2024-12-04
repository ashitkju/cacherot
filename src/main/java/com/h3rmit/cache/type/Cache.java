package com.h3rmit.cache.type;

public interface Cache {
    Object get(String key);
    String put(String key, Object value);
    String remove(String key);
    void clear();
    void evict();
}

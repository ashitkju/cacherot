package com.h3rmit.api;

import com.h3rmit.dto.CacheData;

import jakarta.ws.rs.core.Response;

public interface CacheApi {
    Response put(CacheData data);
}

package com.entitymappinglab.entitymappinglab.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void evictAllCaches() {
        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    public void evictSingleCache(String cacheName) {
        cacheManager.getCache(cacheName).clear();
    }

    public void evictSingleCacheValue(String cacheName, Object key) {
        cacheManager.getCache(cacheName).evict(key);
    }
}

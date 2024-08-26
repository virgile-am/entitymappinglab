package com.entitymappinglab.entitymappinglab.controller;

import com.entitymappinglab.entitymappinglab.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping("/evictAll")
    public void evictAllCaches() {
        cacheService.evictAllCaches();
    }

    @PostMapping("/evictCache")
    public void evictSingleCache(String cacheName) {
        cacheService.evictSingleCache(cacheName);
    }

    @PostMapping("/evictCacheValue")
    public void evictSingleCacheValue(String cacheName, Object key) {
        cacheService.evictSingleCacheValue(cacheName, key);
    }
}

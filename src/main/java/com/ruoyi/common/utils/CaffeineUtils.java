package com.ruoyi.common.utils;

import com.github.benmanes.caffeine.cache.Cache;
import com.ruoyi.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Component;

/**
 * Caffeine缓存工具类
 **/
@Component
public class CaffeineUtils {

//    @Autowired
//    Cache<String, Object> caffeineCache;
    @Autowired
    CacheManager caffeineCacheManager;
    /**
     * 添加或更新缓存
     *
     * @param key
     * @param value
     */
//    public void putAndUpdateCache(String key, Object value) {
//        caffeineCache.put(key, value);
//    }


    /**
     * 获取对象缓存
     *
     * @param key
     * @return
     */
//    public <T> T getObjCacheByKey(String key, Class<T> t) {
//        caffeineCache.getIfPresent(key);
//        return (T) caffeineCache.asMap().get(key);
//    }

    /**
     * 根据key删除缓存
     *
     * @param key
     */
//    public void removeCacheByKey(String key) {
//        // 从缓存中删除
//        caffeineCache.asMap().remove(key);
//    }


    //默认取TOKEN_CACHE
    public void putAndUpdateCache(String key, Object value) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(Constants.TOKEN_CACHE);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.put(key, value);
    }

    public <T> T getObjCacheByKey(String key, Class<T> t) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(Constants.TOKEN_CACHE);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.getIfPresent(key);
        return (T) caffeineCache.asMap().get(key);
    }


    public void removeCacheByKey(String key) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(Constants.TOKEN_CACHE);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.asMap().remove(key);
    }

    public void putAndUpdateCache(String key, Object value, String cacheName) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(cacheName);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.put(key, value);
    }

    public <T> T getObjCacheByKey(String key, Class<T> t, String cacheName) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(cacheName);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.getIfPresent(key);
        return (T) caffeineCache.asMap().get(key);
    }


    public void removeCacheByKey(String key, String cacheName) {
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(cacheName);
        Cache<Object, Object> caffeineCache = cache.getNativeCache();
        caffeineCache.asMap().remove(key);
    }

}


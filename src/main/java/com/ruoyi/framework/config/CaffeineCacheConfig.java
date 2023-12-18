package com.ruoyi.framework.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.ruoyi.common.constant.CacheType;
import com.ruoyi.common.constant.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {

    @Value("${token.expireTime}")
    private int expireTime;

//    @Bean
//    public Cache<String, Object> caffeineCache() {
//        return Caffeine.newBuilder()
//                // 设置最后一次写入或访问后经过固定时间过期
//                .expireAfterWrite(expireTime, TimeUnit.SECONDS)
//                // 初始的缓存空间大小
//                .initialCapacity(50)
//                // 缓存的最大条数
//                .maximumSize(500)
//                .build();
//    }

//    @Bean
//    public CacheManager cacheManager() {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//        cacheManager.setCaffeine(Caffeine.newBuilder()
//                // 设置最后一次写入或访问后经过固定时间过期
//                .expireAfterWrite(expireTime, TimeUnit.SECONDS)
//                // 初始的缓存空间大小
//                .initialCapacity(50)
//                // 缓存的最大条数
//                .maximumSize(500));
//        return cacheManager;
//    }


    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<CaffeineCache> caffeineCaches = new ArrayList<>();

        //设置token缓存
        caffeineCaches.add(new CaffeineCache(Constants.TOKEN_CACHE,
                Caffeine.newBuilder()
                        .expireAfterWrite(expireTime, TimeUnit.SECONDS)
                        .initialCapacity(5)
                        .maximumSize(10)
                        .build()));

        //设置其它 可配置
        for (CacheType cacheType : CacheType.values()) {
            caffeineCaches.add(new CaffeineCache(cacheType.name(),
                    Caffeine.newBuilder()
                            .expireAfterWrite(cacheType.getExpires(), TimeUnit.SECONDS)
                            .initialCapacity(1)
                            .maximumSize(10)
                            .build()));
        }

        cacheManager.setCaches(caffeineCaches);

        return cacheManager;
    }

}

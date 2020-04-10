//package com.imooc.web1.config;
//
//import lombok.extern.slf4j.Slf4j;
//import lombok.var;
//import org.springframework.cache.Cache;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.CacheErrorHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//@EnableCaching
//@Slf4j
//public class RedisConfig {
//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        var redisTemplate = new RedisTemplate() {
//            @Override
//            public Object execute(RedisCallback action, boolean exposeConnection, boolean pipeline) {
//                //拦截缓存异常
//                try {
//                    return super.execute(action, exposeConnection, pipeline);
//                } catch (Exception ex) {
//                    log.error("Redis 异常：", ex);
//                }
//
//                return null;
//            }
//        };
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheErrorHandler errorHandler() {
//        CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
//
//            @Override
//            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
//                log.error(String.format("Redis 异常，[Key]:%s", key != null ? key.toString() : "NULL"), e);
//            }
//
//            @Override
//            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
//                log.error(String.format("Redis 异常，[Key]:%s", key != null ? key.toString() : "NULL"), e);
//            }
//
//            @Override
//            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
//                log.error("Redis 异常", e);
//            }
//
//            @Override
//            public void handleCacheClearError(RuntimeException e, Cache cache) {
//                log.error("Redis 异常", e);
//            }
//        };
//
//        return cacheErrorHandler;
//    }
//}

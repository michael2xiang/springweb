//package com.imooc.web1.config.redisratelimit;
//
//import com.imooc.web1.common.RateLimitMethodEnum;
//import com.imooc.web1.common.RateLimitResultEnum;
//import com.imooc.web1.response.RateLimitVo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.script.RedisScript;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.Collections;
//
//@Service
//@Slf4j
//public class RateLimitClient {
//    private static final String RATE_LIMIT_PREFIX = "ratelimit:";
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Autowired
//    @Resource
//    @Qualifier("rateLimitLua")
//    RedisScript<Long> rateLimitScript;
//
//    public RateLimitResultEnum init(String key, RateLimitVo rateLimitInfo){
//        return exec(key, RateLimitMethodEnum.init,
//                rateLimitInfo.getInitialPermits(),
//                rateLimitInfo.getMaxPermits(),
//                rateLimitInfo.getInterval(),
//                key);
//    }
//
//    public RateLimitResultEnum modify(String key, RateLimitVo rateLimitInfo){
//        return exec(key, RateLimitMethodEnum.modify, key,
//                rateLimitInfo.getMaxPermits(),
//                rateLimitInfo.getInterval());
//    }
//
//    public RateLimitResultEnum delete(String key){
//        return exec(key, RateLimitMethodEnum.delete);
//    }
//
//    public RateLimitResultEnum acquire(String key){
//        return acquire(key, 1);
//    }
//
//    public RateLimitResultEnum acquire(String key, Integer permits){
//        return exec(key, RateLimitMethodEnum.acquire, permits);
//    }
//
//    /**
//     * 执行redis的具体方法，限制method,保证没有其他的东西进来
//     * @param key
//     * @param method
//     * @param params
//     * @return
//     */
//    private RateLimitResultEnum exec(String key, RateLimitMethodEnum method, Object... params){
//        try {
//            Long timestamp = getRedisTimestamp();
//            Object[] allParams = new String[params.length + 2];
//            allParams[0] = method.name();
//            allParams[1] = timestamp.toString();
//            for(int index = 0;index < params.length; index++){
//                allParams[2 + index] = params[index].toString();
//            }
//            Long result;
//
//            result = redisTemplate.execute(rateLimitScript,
//                    Collections.singletonList(getKey(key)),
//                    allParams);
//            return RateLimitResultEnum.getResult(result);
//        } catch (Exception e){
//            log.error("execute redis script fail, key:{}, method:{}",
//                    key, method.name(), e);
//            return RateLimitResultEnum.ERROR;
//        }
//    }
//
//    private Long getRedisTimestamp(){
//        Long currMillSecond = redisTemplate.execute(
//                (RedisCallback<Long>) redisConnection -> redisConnection.time()
//        );
//        return currMillSecond;
//    }
//    private String getKey(String key){
//        return RATE_LIMIT_PREFIX + key;
//    }
//}

//package com.imooc.web1.config.redisratelimit;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisScriptConfig {
//
//    @Bean("rateLimitLua")
//    public DefaultRedisScript<Long> getRateLimitScript() {
//        DefaultRedisScript<Long> rateLimitLua = new DefaultRedisScript<>();
//        rateLimitLua.setLocation(new ClassPathResource("rate_limit.lua"));
//        rateLimitLua.setResultType(Long.class);
//        return rateLimitLua;
//    }
//
//}

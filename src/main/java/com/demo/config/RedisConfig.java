//package com.demo.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//import java.lang.reflect.Method;
//
///**
// * Created by Administrator on 2016/11/24.
// */
//@Configuration
//@EnableCaching
//public class RedisConfig {
//
//    @Bean
//    public KeyGenerator keyGenerator(){
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append(target.getClass().getName());
//                stringBuilder.append(method.getName());
//                for (Object obj:params
//                     ) {
//                    stringBuilder.append(obj.toString());
//                }
//                return stringBuilder.toString();
//            }
//        };
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        return new RedisCacheManager(redisTemplate);
//    }
//
//    @Bean
//    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        stringRedisTemplate.afterPropertiesSet();
//        return stringRedisTemplate;
//    }
//
//}

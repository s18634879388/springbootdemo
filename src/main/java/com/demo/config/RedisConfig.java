package com.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/11/24.
 */
@Configuration
public class RedisConfig {

    //缓存中key的自动生成方式，此处配置为类权限定名+方法名
    //在要使用缓存的方法上添加注解@Cacheable(value = "XXXX",keyGenerator = "keyGenerator")
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object obj:params
                     ) {
                    stringBuilder.append(obj.toString());
                }
                return stringBuilder.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        //设置缓存过期时间，60秒
//        new RedisCacheManager(redisTemplate).setDefaultExpiration(60);
        return new RedisCacheManager(redisTemplate);
    }



        //spring boot为我们自动配置了RedisTemplate，而RedisTemplate使用的是JDKSerializationRedisSerializer(二进制)
        //因此我们自己配置RedisTemplate，并定义Serializer
        @Bean
        public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
            RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object, Object>();
            redisTemplate.setConnectionFactory(redisConnectionFactory);

            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            //设置值(value)的序列化采用Jackson2JsonRedisSerializer
            redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//          //设置键(key)的序列化采用StringRedisSerializer
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.afterPropertiesSet();
            return redisTemplate;
        }

}

package com.xie.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by xie on 17/8/24.
 */
@Configuration
public class CacheConfig {
    public static final int DEFAULT_MAXSIZE = 50000;
    public static final int DEFAULT_TTL = 10;

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        expireAfterWrite(DEFAULT_TTL, TimeUnit.SECONDS).
                        maximumSize(DEFAULT_MAXSIZE));
        return cacheManager;
    }


//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//    @Value("${spring.redis.pool.max-idle}")
//    private int maxIdle;
//    @Value("${spring.redis.pool.min-idle}")
//    private int minIdle;
//
//    @Bean
//    public KeyGenerator wiselyKeyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : params) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//    }
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setHostName(host);
//        factory.setPort(port);
//        factory.setTimeout(timeout); //设置连接超时时间
//        factory.setPoolConfig(jedisPoolConfig());
//        factory.setUsePool(true);
//        return factory;
//    }
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMinIdle(maxIdle);
//        poolConfig.setMinIdle(maxIdle);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnCreate(true);
//        poolConfig.setTestWhileIdle(true);
//        poolConfig.setMaxTotal(200);
//        return poolConfig;
//    }
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        setSerializer(template); //设置序列化工具，这样ReportBean不需要实现Serializable接口
//        template.afterPropertiesSet();
//        return template;
//    }
//    private void setSerializer(StringRedisTemplate template) {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//    }
//
//
//    @Bean(name = "redisCacheManager")
//    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        // Number of seconds before expiration. Defaults to unlimited (0)
//        cacheManager.setDefaultExpiration(0); //设置key-value超时时间
//        return cacheManager;
//    }
//    @Bean(name = "fyCacheManager")
//    public CacheManager fyCacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager fyCacheManager = new RedisCacheManager(redisTemplate);
//        fyCacheManager.setUsePrefix(true);
//        fyCacheManager.setCachePrefix(cacheName -> "fy".getBytes());
//        fyCacheManager.setDefaultExpiration(0);
//        return fyCacheManager;
//    }
//    @Bean(name = "taskTypeCacheManager")
//    public CacheManager taskTypeCacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager taskTypeCacheManager = new RedisCacheManager(redisTemplate);
//        taskTypeCacheManager.setDefaultExpiration(60 * 60);
//        return taskTypeCacheManager;
//    }
//
}



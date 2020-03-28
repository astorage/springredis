package com.java.springredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Boris
 * @date 2020/3/11 19:42
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        if (!(redisConnectionFactory instanceof LettuceConnectionFactory)) {
            throw new RuntimeException(
                    "unsuport redis connection factory! " + redisConnectionFactory);
        }
        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisConnectionFactory;
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                lettuceConnectionFactory.getHostName(), lettuceConnectionFactory.getPort());
        //redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPassword(lettuceConnectionFactory.getPassword());
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(
                redisStandaloneConfiguration, lettuceConnectionFactory.getClientConfiguration());
        connectionFactory.afterPropertiesSet(); //这句一定不能少

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer<String> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, String> strRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        if (!(redisConnectionFactory instanceof LettuceConnectionFactory)) {
            throw new RuntimeException(
                    "unsuport redis connection factory! " + redisConnectionFactory);
        }
        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisConnectionFactory;
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                lettuceConnectionFactory.getHostName(), lettuceConnectionFactory.getPort());
        //redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPassword(lettuceConnectionFactory.getPassword());
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(
                redisStandaloneConfiguration, lettuceConnectionFactory.getClientConfiguration());
        connectionFactory.afterPropertiesSet(); //这句一定不能少

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        return redisTemplate;
    }


    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        if (!(redisConnectionFactory instanceof LettuceConnectionFactory)) {
            throw new RuntimeException(
                    "unsuport redis connection factory! " + redisConnectionFactory);
        }
        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisConnectionFactory;
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                lettuceConnectionFactory.getHostName(), lettuceConnectionFactory.getPort());
        //redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPassword(lettuceConnectionFactory.getPassword());
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(
                redisStandaloneConfiguration, lettuceConnectionFactory.getClientConfiguration());
        connectionFactory.afterPropertiesSet(); //这句一定不能少

        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }






}

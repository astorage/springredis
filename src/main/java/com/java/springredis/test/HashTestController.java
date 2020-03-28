package com.java.springredis.test;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HashTestController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/test/hash/hset/int")
    public void testHash_hset(String key, String feild, Integer num) {
        redisTemplate.opsForHash().put(key, feild, num);
    }

    @RequestMapping("/test/hash/hset/double")
    public void testHash_hset(String key, String feild, Double num) {
        redisTemplate.opsForHash().put(key, feild, num);
    }

    @RequestMapping("/test/hash/hset/string")
    public void testHash_hset(String key, String feild, String str) {
        redisTemplate.opsForHash().put(key, feild, str);
    }


    @RequestMapping("/test/hash/hget")
    public Object testHash_hget(String key, String feild) {
        Object value = redisTemplate.opsForHash().get(key, feild);
        return value;
    }

    @RequestMapping("/test/hash/hincrby/long")
    public Long testHash_hincrby(String key, String feild, Long increment) {
        Long value = redisTemplate.opsForHash().increment(key, feild, increment);
        return value;
    }

    @RequestMapping("/test/hash/hincrby/double")
    public Double testHash_hincrby(String key, String feild, Double increment) {
        Double value = redisTemplate.opsForHash().increment(key, feild, increment);
        return value;
    }
}

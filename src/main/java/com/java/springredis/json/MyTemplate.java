package com.java.springredis.json;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Boris
 * @date 2020/3/27 12:22
 */
@Component
public class MyTemplate {

    @Autowired
    private StringRedisTemplate redisTemplate;



    public<T> T get(String key, Class<T> valueClass) {
        String jsonValue = redisTemplate.opsForValue().get(key);
        return (T)JSON.parseObject(jsonValue, valueClass);
    }


    public<V> void set(String key, V value) {
        String jsonValue = JSON.toJSONString(value);
        redisTemplate.opsForValue().set(key, jsonValue);
    }

    public Long incr(String key) {
        Long newValue = redisTemplate.opsForValue().increment(key);
        return newValue;
    }

    public Long incrby(String key, Long increment) {
        Long newValue = redisTemplate.opsForValue().increment(key, increment);
        return newValue;
    }

    public Double incrbyfloat(String key, Double increment) {
        Double newValue = redisTemplate.opsForValue().increment(key, increment);
        return newValue;
    }

    public Long decr(String key) {
        Long newValue = redisTemplate.opsForValue().decrement(key);
        return newValue;
    }

    public Long decrby(String key, Long delta) {
        Long newValue = redisTemplate.opsForValue().decrement(key, delta);
        return newValue;
    }

    public Integer append(String key, String value) {
        Integer length = redisTemplate.opsForValue().append(key, value);
        return length;
    }

    public Boolean setbit(String key, Long offset, Boolean value) {
        Boolean oldBit = redisTemplate.opsForValue().setBit(key, offset, value);
        return oldBit;
    }

    public Boolean getbit(String key, Long offset) {
        Boolean bit = redisTemplate.opsForValue().getBit(key, offset);
        return bit;
    }

    public String getrange(String key, Long offset, Long end) {
        String subValue = redisTemplate.opsForValue().get(key, offset, end);
        return subValue;
    }


    public<V> void setrange(String key, V value, Long offset) {
        String jsonValue = JSON.toJSONString(value);
        redisTemplate.opsForValue().set(key, jsonValue, offset);
    }

    public<V> List<V> multiGet(List<String> keys, Class<V> valueClass) {
        List<String> values = redisTemplate.opsForValue().multiGet(keys);
        List<V> vList = values.stream().map(value -> JSON.parseObject(value, valueClass))
                .collect(Collectors.toList());
        return vList;
    }

    public Long strlen(String key) {
        Long length = redisTemplate.opsForValue().size(key);
        return length;
    }

    public <V> Boolean setnx(String key, V value) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfAbsent(key, jsonValue);
        return setFlag;
    }

    public <V> Boolean setnxExpire(String key, V value, Long timeout) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfAbsent(key, jsonValue, timeout, TimeUnit.SECONDS);
        return setFlag;
    }

    public <V> Boolean setnxExpire1(String key, V value, Long timeout) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfAbsent(key, jsonValue, Duration.ofSeconds(timeout));
        return setFlag;
    }


    public <V> Boolean setex(String key, V value) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfPresent(key, jsonValue);
        return setFlag;
    }

    public <V> Boolean setexExpire(String key, V value, Long timeout) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfPresent(key, jsonValue, timeout, TimeUnit.SECONDS);
        return setFlag;
    }

    public <V> Boolean setexExpire1(String key, V value, Long timeout) {
        String jsonValue = JSON.toJSONString(value);
        Boolean setFlag = redisTemplate.opsForValue().setIfPresent(key, jsonValue, Duration.ofSeconds(timeout));
        return setFlag;
    }

    public <V> Boolean msetnx(Map<String, V> keyValueMap) {
        Map<String, String> map = new HashMap<>();
        keyValueMap.entrySet().forEach(entry -> map.put(entry.getKey(), JSON.toJSONString(entry.getValue())));
        Boolean setFlag = redisTemplate.opsForValue().multiSetIfAbsent(map);
        return setFlag;
    }











}

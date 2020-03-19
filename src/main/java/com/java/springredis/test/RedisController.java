package com.java.springredis.test;

import com.java.springredis.model.Student;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Boris
 * @date 2020/3/19 11:39
 */
@RestController
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/test/set/add/obj")
    public void testSetAddObj(String key, @RequestBody Student student) {
        redisTemplate.opsForSet().add(key, student);
    }

    @RequestMapping("/test/set/add/string")
    public void testSetAdd(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    @RequestMapping("/test/set/add/double")
    public void testSetAdd(String key, Double value) {
        redisTemplate.opsForSet().add(key, value);
    }

    @RequestMapping("/test/set/add/int")
    public void testSetAdd(String key, Integer value) {
        redisTemplate.opsForSet().add(key, value);
    }

    @RequestMapping("/test/set/smembers")
    public Set testSetSmembers(String key) {
        Set members = redisTemplate.opsForSet().members(key);
        return members;
    }

    @RequestMapping("/test/set/scard")
    public Long testSetScard(String key) {
        Long size = redisTemplate.opsForSet().size(key);
        return size;
    }

    @RequestMapping("/test/set/sismember")
    public Boolean testSetSismember(String key, Object value) {
        Boolean isMember = redisTemplate.opsForSet().isMember(key, value);
        return isMember;
    }

    @RequestMapping("/test/set/spop")
    public Object testSetSpop(String key) {
        Object element = redisTemplate.opsForSet().pop(key);
        return element;
    }

    @RequestMapping("/test/set/spop/multi")
    public List<Object> testSetSpop(String key, Long num) {
        List<Object> elementList = redisTemplate.opsForSet().pop(key, num);
        return elementList;
    }

    @RequestMapping("/test/set/srem")
    public Long testSetSrem(String key, Object[] members) {
        Long removeNum = redisTemplate.opsForSet().remove(key, members);
        return removeNum;
    }

    @RequestMapping("/test/set/sscan")
    public Object testSetSscan(String key, ScanOptions options) {
        Cursor cursor = redisTemplate.opsForSet().scan(key, options);
        return cursor;
    }



    @RequestMapping("/test/set/smove")
    public Boolean testSetSmove(String resource, String destnation, Object value) {
        Boolean moveSuccess = redisTemplate.opsForSet().move(resource, value, destnation);
        return moveSuccess;
    }



}

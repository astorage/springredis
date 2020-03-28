package com.java.springredis.test;

import com.java.springredis.json.MyTemplate;
import com.java.springredis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Boris
 * @date 2020/3/26 18:27
 */
@RestController
public class ValueController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisTemplate<String, Object> strRedisTemplate;
    @Resource
    private MyTemplate myTemplate;

    @RequestMapping("/test/value/get/int")
    public Integer testGet(String key) {
        Integer value = myTemplate.get(key, Integer.class);
        return value;
    }

    @RequestMapping("/test/value/set/int")
    public void testGet(String key, Integer value) {
        myTemplate.set(key, value);
    }

    @RequestMapping("/test/value/incr")
    public Long incr(String key) {
        Long value = myTemplate.incr(key);
        return value;
    }

    @RequestMapping("/test/value/get/double1")
    public Double testGetDouble1(String key) {
        Double value = myTemplate.get(key, Double.class);
        return value;
    }

    @RequestMapping("/test/value/set/double1")
    public void testSetDouble1(String key, Double value) {
        myTemplate.set(key, value);
    }

    @RequestMapping("/test/value/get/double")
    public Double testGetDouble(String key) {
        Double value = (Double)redisTemplate.opsForValue().get(key);
        return value;
    }

    @RequestMapping("/test/value/set/double")
    public void testSetDouble(String key, Double value) {
        strRedisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/test/value/set/string")
    public void testSetStr(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/test/value/get/string")
    public Object testGetStr(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value;
    }


    @RequestMapping("/test/value/set/string1")
    public void testSetStr1(String key, String value) {
        strRedisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/test/value/get/string1")
    public Object testGetStr1(String key) {
        Object value = strRedisTemplate.opsForValue().get(key);
        return value;
    }

    @RequestMapping("/test/value/set/obj")
    public void testSetObj(String key, @RequestBody Student student) {
        redisTemplate.opsForValue().set(key, student);
    }

    /**
     * 用jackson 序列化，可以将对象set.但是获取出来的确实LinkedHashMap
     * @param key
     * @return
     */
    @RequestMapping("/test/value/get/obj")
    public Object testSetObj(String key) {
        Object student = redisTemplate.opsForValue().get(key);
        return student;
    }



    @RequestMapping("/test/value/set/obj1")
    public void testSetObj1(String key, @RequestBody Student student) {
        myTemplate.set(key, student);
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("/test/value/get/obj1")
    public Student testSetObj1(String key) {
        Student student = myTemplate.get(key, Student.class);
        return student;
    }


    @RequestMapping("/test/value/set/int1")
    public void testSetint1(String key,Integer value) {
        strRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("/test/value/get/int1")
    public Object testGetint1(String key) {
        Object value = strRedisTemplate.opsForValue().get(key);
        return value;
    }

}

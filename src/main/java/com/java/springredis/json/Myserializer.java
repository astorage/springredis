package com.java.springredis.json;

import com.alibaba.fastjson.JSON;
import com.java.springredis.model.Address;
import com.java.springredis.model.Student;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boris
 * @date 2020/3/27 10:09
 */
public class Myserializer implements RedisSerializer {



    @Override
    public byte[] serialize(Object o) throws SerializationException {


        return new byte[0];
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return null;
    }

    public static void main(String[] args) {
        testIntegerJson();
    }

    private static void testIntegerJson () {
        String jsonStr = JSON.toJSONString(1);
        System.out.println(jsonStr);
    }

    private void testObjJson () {
        Student student = new Student();
        student.setId(1l);
        student.setName("sdfdf");
        Address address = new Address();
        address.setId(2l);
        address.setMail("adfsdf@qq.com");
        address.setAddress("dfsfdsdfsf");
        address.setMobile("15823456789");
        student.setAddress(address);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("sdfsf");
        hobbies.add("kljlljf");
        student.setHobbies(hobbies);

        String jsonStr = JSON.toJSONString(student);
        System.out.println(jsonStr);
    }
}

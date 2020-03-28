package com.java.springredis.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.java.springredis.model.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Boris
 * @date 2020/3/27 10:47
 */
public class Testsfsd {

    public static void main(String[] args) {
        JavaType javaType = getJavaType(HashMap.class);
        System.out.println(javaType);
    }

    private static JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}

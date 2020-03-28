package com.java.springredis.json;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Boris
 * @date 2020/3/27 13:40
 */
@Aspect
@Component
public class RedisValueAspect {


    @Pointcut("execution(public * org.springframework.data.redis.core.ValueOperations.*(..))")
    public void ValueOperationsPointcut(){

    }




}

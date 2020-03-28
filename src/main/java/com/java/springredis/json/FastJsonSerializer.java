package com.social.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author Boris
 * @date 2020/3/6 21:55
 */
public class FastJsonSerializer implements RedisSerializer<Object> {

    private final static ParserConfig defaultRedisConfig = new ParserConfig();
    static { defaultRedisConfig.setAutoTypeSupport(false);}

    /**
     * DEFAULT_CHARSET
     */
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");


    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if (obj == null) {
            return new byte[0];
        } else {
            try {
                return JSON.toJSONBytes(obj);
            } catch (Exception var3) {
                throw new SerializationException("Could not serialize: " + var3.getMessage(), var3);
            }
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, Object.class, defaultRedisConfig);

    }
}

package com.itmayiedu.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @param --吴林
 * @date 2019/3/14 0014 14:13
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString (String key,String  value) {
        this.setObject(key, value, null);
    }
    public void setString (String key,String  value ,Long time) {
        this.setObject(key, value, time);
    }
    public void setlist (String key,List<String> listvalue,Long time) {
        this.setObject(key, listvalue, time);
    }
    public void setlist (String key,List<String> listvalue) {
        this.setObject(key, listvalue, null);
    }


    public void setObject(String key ,Object value ,Long time) {
        if (StringUtils.isEmpty(key) || value == null)
            if (value instanceof String) {
                return;
            }
        //判断类型存放string类型
        if (value instanceof String) {
            String strValue = (String) value;
            stringRedisTemplate.opsForValue().set(key, strValue);
            if (time != null) {
                stringRedisTemplate.opsForValue().set(key, strValue, time, TimeUnit.SECONDS);
            }
            return;
        }
        //判断存放list类型
        if (value instanceof List) {
            List<String> listValue = (List<String>) value;
            for (String string : listValue) {
                stringRedisTemplate.opsForList().leftPush(key, string);
            }
            return;
            //封装   set map 排序set
        }
    }
            public String getStringKey(String key) {
                return stringRedisTemplate.opsForValue().get(key);
            }
}

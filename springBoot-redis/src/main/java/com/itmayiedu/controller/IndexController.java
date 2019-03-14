package com.itmayiedu.controller;

import com.itmayiedu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @param --吴林
 * @date 2019/3/14 0014 15:19
 */
@RestController
public class IndexController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("setString")
    public String setString(String key, String value) {
        redisService.setString(key, value);
        return "success";
    }
    @RequestMapping("setList")
    public String setList(String key) {
        List<String> listString =new ArrayList<String>();
        listString.add("123");
        listString.add("456");
        redisService.setlist(key,listString);
        return "success";
    }
    @RequestMapping("getKey")
    public String getKey(String key) {
        return redisService.getStringKey(key);
    }
}

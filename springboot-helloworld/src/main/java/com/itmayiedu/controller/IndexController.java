package com.itmayiedu.controller;

import com.itmayiedu.dao.UserDao;
import com.itmayiedu.entity.User;
import com.itmayiedu.mapper.UserMapper;
import com.itmayiedu.test01.dao.UserMapperTest01;
import com.itmayiedu.test01.dao.service.UserServiceTest01;
import com.itmayiedu.test02.dao.UserMapperTest02;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static Logger log = Logger.getLogger(IndexController.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperTest01 userMapperTest01;
    @Autowired
    private UserMapperTest02 userMapperTest02;
    @Autowired
    private UserServiceTest01 userServiceTest01;
    @RequestMapping("/index")
    public String index(Integer id) {
        User findUser = userDao.findOne(id);
        System.out.println(findUser.getName());
        return "success";
    }

    @RequestMapping("/insertTest001")
    public String insertTest001(String name, Integer age) {
        userServiceTest01.insertTest001(name,age);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/findByNameTest01")
    public User findByNameTest01(String name) {
        log.info("####findByName()####name:"+name);
        return userMapperTest01.findByName(name);
    }
    @RequestMapping("/insertTest002")
    public String insertTest002(String name, Integer age) {
        userMapperTest02.insert(name,age);
        return "success";
    }
}

package com.itmayiedu.test01.dao.service;

import com.itmayiedu.test01.dao.UserMapperTest01;
import com.itmayiedu.test02.dao.UserMapperTest02;
import com.itmayiedu.test02.dao.service.UserServiceTest02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceTest01 {
    @Autowired
    public UserMapperTest01 userMapperTest01;
    @Autowired
    public UserMapperTest02 userMapperTest02;
   // public UserServiceTest02 userServiceTest02;
    /**
     * 声明是事务
     * @param name
     * @param age
     * @return
     */
    @Transactional
    public String insertTest001(String name, Integer age) {
        userMapperTest01.insert(name, age);
       // userServiceTest02.insertTest001(name, age);
        userMapperTest02.insert(name,age);
        return "success";
    }
}
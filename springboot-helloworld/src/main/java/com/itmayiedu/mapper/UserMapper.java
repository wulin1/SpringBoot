package com.itmayiedu.mapper;
import com.itmayiedu.entity.User;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into users values(null,#{name},#{age});")
    public int addUser(@Param("name") String name, @Param("age") Integer age);
}
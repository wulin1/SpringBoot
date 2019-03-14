package com.itmayiedu.dao;

import com.itmayiedu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {


}
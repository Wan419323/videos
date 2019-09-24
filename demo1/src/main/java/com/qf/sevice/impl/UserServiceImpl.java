package com.qf.sevice.impl;

import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author L
 * @date 2019/9/1614:18
 */
public class UserServiceImpl implements UserService {


  @Autowired
  private UserMapper userMapper;

    @Override
    public User Login(User user) {

        return userMapper.Login(user);
    }
}

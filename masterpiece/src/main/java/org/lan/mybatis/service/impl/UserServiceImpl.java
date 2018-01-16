package org.lan.mybatis.service.impl;

import org.lan.mybatis.dao.UserMapper;
import org.lan.mybatis.domain.User;
import org.lan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    public User getUserInfoByUserName(String username, String password) {
        return userMapper.getUserInfoByUserName(username,  password);
    }
}

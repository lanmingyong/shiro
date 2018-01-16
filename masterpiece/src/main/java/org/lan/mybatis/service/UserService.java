package org.lan.mybatis.service;

import org.apache.ibatis.annotations.Param;
import org.lan.mybatis.domain.User;

public interface UserService {
    public User getUserInfoByUserName(String username,String password);
}

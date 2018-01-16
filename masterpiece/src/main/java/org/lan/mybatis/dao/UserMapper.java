package org.lan.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.lan.mybatis.domain.User;

public interface UserMapper {
    public User getUserInfoByUserName(@Param("username") String username, @Param("password") String password);
}

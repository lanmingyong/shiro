package org.lan.dao;

import org.lan.pojo.Users;

public interface UsersMapper {
	//查询某个用户
	public Users selectUserById(Integer id);
}

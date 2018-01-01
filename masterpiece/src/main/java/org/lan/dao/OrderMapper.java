package org.lan.dao;

import java.util.List;

import org.lan.pojo.Order;

public interface OrderMapper {
	//查询用户所有的订单
public List<Order> selectOrderByUserId(Integer id);
}

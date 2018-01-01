package org.lan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.lan.dao.OrderMapper;
import org.lan.pojo.Order;
import org.lan.util.MybatisUtils;

public class OrderService {
 private SqlSession sqlSession=MybatisUtils.createSqlsession();
 private OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
 public List<Order> selectOrderByUserId(Integer id){
	 return orderMapper.selectOrderByUserId(id);
 }
}

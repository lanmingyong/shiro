package org.lan.dao;

import org.lan.pojo.Article;

public interface ArticleMapper {
	//查询订单中的所有商品
public Article selectArticleByOrderId(Integer id);
}

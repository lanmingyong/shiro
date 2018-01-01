package org.lan.pojo;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private static final long serialVersionUID = -6718158984081463394L;
	private Integer id;
	private String code;
	private Double total;
	private Users users;
	private List<Article> articles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", total=" + total + ", users=" + users + ", articles=" + articles
				+ "]";
	}

}

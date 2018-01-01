package org.lan.pojo;

import java.io.Serializable;

public class Card implements Serializable {

	private static final long serialVersionUID = -6930424855337722770L;
	private Integer id;
	private String code;

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

	@Override
	public String toString() {
		return "Card [id=" + id + ", code=" + code + "]";
	}

	
}

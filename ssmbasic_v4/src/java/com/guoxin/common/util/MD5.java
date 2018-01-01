package com.guoxin.common.util;

import java.security.MessageDigest;

public class MD5 {

	public MD5() {
	}

	public static String encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			//返回实现指定摘要算法的 MessageDigest 对象,所请求算法的名称是MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组。
			//digest()使用指定的字节数组对摘要进行最后更新，然后完成摘要计算。
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		//使用 toUpperCase() 来把字符串转换成大写
		return resultString.toUpperCase();
	}
	/**
	 * 将计算结果(byte数组)转换为字符串
	 * @param bytes
	 * @return
	 */
	public static final String byte2hexString(byte bytes[]) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 16)
				buf.append("0");
			buf.append(Long.toString(bytes[i] & 0xff, 16));
		}

		return buf.toString();
	}

}

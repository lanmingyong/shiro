package org.lan.designpattern.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件，使用单例模式的懒汉模式
 * @author LANMINGYONG
 *
 */
public class ConfigManager2 {
	private static ConfigManager2 configManager=new ConfigManager2();
private static Properties properties;
private ConfigManager2() {
	String configFile="database.properties";
	properties=new Properties();
	InputStream is=ConfigManager2.class.getClassLoader().getResourceAsStream(configFile);
	try {
		properties.load(is);
		is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 饿汉模式就是在类加载时就完成初始化操作，故加载速度慢但获取对象的速度快。
 * 并且由于饿汉模式是在类加载时就已经自行实例化，因此它不存在线程安全的问题。
 * @return
 */
public static  ConfigManager2 getInstance() {
	
	return configManager;
}
public String getValue(String key) {
	return properties.getProperty(key);
}
}

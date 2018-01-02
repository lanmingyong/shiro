package org.lan.designpattern.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件，使用单例模式的懒汉模式
 * @author LANMINGYONG
 *
 */
public class ConfigManager {
	private static ConfigManager configManager;
private static Properties properties;
private ConfigManager() {
	String configFile="database.properties";
	properties=new Properties();
	InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
	try {
		properties.load(is);
		is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 所谓懒汉模式，正如其名“比较懒”，即在类加载的时候不创建实例，采用延迟加载的方式，在运行调用时创建实例。
 * 采用synchronized关键字实现多线程同步，解决线程安全的问题。
 * @return
 */
public static synchronized ConfigManager getInstance() {
	if(configManager == null) {
		configManager=new ConfigManager();
	}
	return configManager;
}
public String getValue(String key) {
	return properties.getProperty(key);
}
}

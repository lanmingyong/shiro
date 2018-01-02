package org.lan.designpattern.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Singleton {
	private static Singleton singleton;
	private static Properties properties;
	private Singleton() {
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

	public static class SingletonHepler()
	{
		private static final Singleton INSTANCE = new Singleton();
	}

public static Singleton getInstance() {
	return SingletonHepler.INSTANCE;
}

public static void main(String[] args) {
	System.out.println("Singleton.test()----->"+Singleton.test());
	System.out.println("Singleton.getInstance----->"+Singleton.getInstance());
}

private static String test() {
	// TODO Auto-generated method stub
	return singleton;
}
}
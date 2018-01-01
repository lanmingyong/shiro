package com.guoxin.common.base;

import java.io.File;

public class Constants {
	// Dump file store
	public final static String DUMP_FILE_CATALOG = "dump";

	// Query result list
	public final static int QUERY_RESULT_ITEMS_PER_PAGE = 15;

	// Object keys
	public final static String LOGIN_KEY = "guoxin.login";
	public final static String ID_KEY = "id";

	// Format strings
	public final static String FORMAT_STRING_DATE = "yyyy-MM-dd";
	public final static String FORMAT_STRING_TIME = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_STRING_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	public static final String SAVE_PATH = File.separator + "uploadFile" + File.separator;

	// excel 导出临时文件夹
	public static final String EXCEL_TEMPLET_PATH = File.separator + "exceltemplate" + File.separator;
	
	//项目根路径
	public static String ROOT_PATH = "";

}

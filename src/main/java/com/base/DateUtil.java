package com.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
	public static List<String> FORMATS = new ArrayList<>();
	{
		FORMATS.add("yyyy-MM-dd");
		FORMATS.add("yyyy/M/d");
		FORMATS.add("yyyy/MM/dd");
		FORMATS.add("yyyy-MM-dd HH:mm:ss");
		FORMATS.add("yyyy/M/d HH:mm:ss");
		FORMATS.add("yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 
	 * 添加解析日期的格式 默认包含 
	 * yyyy-MM-dd 
	 * yyyy/M/d 
	 * yyyy/MM/dd 
	 * yyyy-MM-dd HH:mm:ss
	 * yyyy/M/d HH:mm:ss 
	 * yyyy/MM/dd HH:mm:ss
	 */
	public static void addParseTimestampFormat(String format) {
		// 为空判断
		if (StringUtil.isNullOrEmpty(format)) {
			return;
		}
		// 防止重复添加
		for (String string : FORMATS) {
			if (string.equals(format)) {
				return;
			}
		}
		FORMATS.add(format);
	}

	/**
	 * @name 解析时间
	 * @description 将 string 类型 转换成 date 类型
	 *              如果需要解析其他类型，通过操作addParseTimestampFormat来添加特殊特使
	 * @author 赵丰登
	 * @return
	 */
	public static Date parseTimestamp(String dateText) {

		for (String sdfStr : FORMATS) {
			SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
			try {
				return sdf.parse(dateText);
			} catch (Exception e) {
			}
		}

		return null;
	}

}

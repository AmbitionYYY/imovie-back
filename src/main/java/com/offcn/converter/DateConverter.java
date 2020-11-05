package com.offcn.converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	public Date convert(String str) {
		try {
			//一个字符串转日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date parse = sdf.parse(str);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

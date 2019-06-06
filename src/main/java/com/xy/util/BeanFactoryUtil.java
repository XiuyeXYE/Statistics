package com.xy.util;

import java.util.Map;

import com.xiuye.util.cls.TypeUtil;
import com.xy.bean.MapResult;

public class BeanFactoryUtil {

	public static MapResult mapResult(boolean success, Map<String,Object> data, String msg, Object status) {
		return TypeUtil.newInstance(MapResult::new,success, data, msg,status);
	}
	
}

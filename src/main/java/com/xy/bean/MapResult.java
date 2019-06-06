package com.xy.bean;

import java.util.Map;

public class MapResult extends Result<Map<String, Object>> {

	public MapResult() {
		super();
	}

	public MapResult(boolean success, Map<String, Object> data, String msg, Object status) {
		super(success, data, msg, status);
	}

	
	
}

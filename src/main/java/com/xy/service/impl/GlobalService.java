package com.xy.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiuye.util.log.LogUtil;
import com.xy.bean.Global;

@Service
public class GlobalService {

	@Resource
	private Global g;

	@PostConstruct
	public void init() {
		LogUtil.log("GlobalService.g =", this.g);
	}

}

package com.xy.oss.test;

import java.io.File;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.xiuye.util.cls.TypeUtil;

public class Oss1 {

	private static String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "s";
    private static String accessKeySecret = "s";
    private static String bucketName = "s";

    public static void main(String[] args) {

		OSS client = new OSSClient(endpoint, accessKeyId,accessKeySecret);
		client.putObject(bucketName,"horse2",TypeUtil.newInstance(File::new,"src/main/resources/static/images/horse.png"));
		
		client.shutdown();
		
	}

}

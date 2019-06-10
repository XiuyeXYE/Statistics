package com.xy.oss.test;

import java.io.File;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;

public class Oss2 {

	private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "tt";
    private static String accessKeySecret = "t";
    private static String bucketName = "tt";
	
	public static void main(String []args) {
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
		ossClient.getObject(new GetObjectRequest(bucketName, "horse"), new File("h.png"));

		// 关闭OSSClient。
		ossClient.shutdown();
	}
	
}

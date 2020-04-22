package com.ry.utils;

import java.io.File;
import java.io.InputStream;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

public class IDCardUtils{
	
	
	
	public static String doPost(String url,  String key,
			String secret, String trueName,String idenNo,String typeId, String format) {
		String result = "";
		try {

			CloseableHttpClient client = HttpClients.createDefault(); // 1.创建httpclient对象
			HttpPost post = new HttpPost(url); // 2.通过url创建post方法

			if ("json".equalsIgnoreCase(format)) {
				post.setHeader("accept", "application/json");
			} else if ("xml".equalsIgnoreCase(format)
					|| "".equalsIgnoreCase(format)) {
				post.setHeader("accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			}

			MultipartEntityBuilder builder = MultipartEntityBuilder.create(); // 实例化实体构造器
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); // 设置浏览器兼容模式

			builder.addPart("key",new StringBody(key, ContentType.create("text/plain",Consts.UTF_8))); // 添加"key"字段及其值
			builder.addPart("secret",new StringBody(secret, ContentType.create("text/plain",Consts.UTF_8))); // 添加"secret"字段及其值
			builder.addPart("trueName",new StringBody(trueName, ContentType.create("text/plain",Consts.UTF_8))); // 添加"secret"字段及其值
			builder.addPart("idenNo",new StringBody(idenNo, ContentType.create("text/plain",Consts.UTF_8))); // 添加"secret"字段及其值
			builder.addPart("typeId",new StringBody(typeId, ContentType.create("text/plain",Consts.UTF_8))); // 添加"typeId"字段及其值
			builder.addPart("format",new StringBody(format, ContentType.create("text/plain",Consts.UTF_8))); // 添加"format"字段及其值

			HttpEntity reqEntity = builder
					.setCharset(CharsetUtils.get("UTF-8")).build(); // 设置请求的编码格式，并构造实体

			post.setEntity(reqEntity);

			CloseableHttpResponse response = client.execute(post); // 4.执行post方法，返回HttpResponse的对象
			if (response.getStatusLine().getStatusCode() == 200) { // 5.如果返回结果状态码为200，则读取响应实体response对象的实体内容，并封装成String对象返回
				result = EntityUtils.toString(response.getEntity(), "UTF-8");
			} else {
				System.out.println("服务器返回异常");
			}

			try {
				HttpEntity e = response.getEntity(); // 6.关闭资源
				if (e != null) {
					InputStream instream = e.getContent();
					instream.close();
				}
	  		} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return result; // 7.返回识别结果

	}
}





package com.demo.query;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
/**
 * IP归属地查询管理类
 * @author Administrator
 *
 */
public class IpAddressQueryContoller extends Controller {
	public void index() {
		Sys sys = Sys.dao.findById(3);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("ipaddressquery.html");
	}

	public void query() {
		String ip =getPara("ip");
		String host = "http://saip.market.alicloudapi.com";
		String path = "/ip";
		String method = "GET";
		String appcode = "d20f34b6df384b3cb13f13fe69fd42e4";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("ip", ip);

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/
			 * pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			System.out.println(response.toString());
			// 获取response的body
			// System.out.println(EntityUtils.toString(response.getEntity()));		
			JSONObject jsonObject =JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
			System.out.println(jsonObject);
			renderJson(new Response(true,jsonObject).toJson());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

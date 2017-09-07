package com.demo.query;

import java.io.UnsupportedEncodingException;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
import com.util.HttpRequest;
/**
 * http模拟查询管理类
 * @author Administrator
 *
 */
public class HttpQueryContoller extends Controller {

	public void index() {
		Sys sys = Sys.dao.findById(2);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("httpquery.html");
	}

	public void query() throws UnsupportedEncodingException {	
		String url = getPara("url");
		String type = getPara("type");
		String param = getPara("param");
		System.out.println(param);
		if (type.equals("get")) {
			// 发送 GET 请求
			String s = HttpRequest.sendGet(url, param);			
			renderJson(new Response(true,s).toJson());
			System.out.println(s);
		} else if (type.equals("post")) {
			// 发送 POST 请求
			String sr = HttpRequest.sendPost(url, param);
			renderJson(new Response(true,sr).toJson());
			System.out.println(sr);
		}

	}

}

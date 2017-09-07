package com.demo.index;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.demo.common.Interceptor.DeviceTypeInterceptor;
import com.demo.common.model.Sys;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 首页管理类
 * 
 * IndexController
 */
public class IndexController extends Controller {

	public void index() {

		setAttr("link", Sys.dao.findAll());
		render("index.html");

	}
}

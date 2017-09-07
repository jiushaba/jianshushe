package com.demo.barcode;

import com.demo.common.Interceptor.DeviceTypeInterceptor;
import com.demo.common.model.Sys;
import com.jfinal.aop.Before;
import com.jfinal.ext.controller.Controller;
/**
 * 条形码生成管理类
 * @author Administrator
 *
 */
public class BarcodeController extends Controller{
	
	public void index(){
		Sys sys = Sys.dao.findById(39);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("create.html");
	}

}

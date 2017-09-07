package com.demo.docs;

import com.demo.common.Interceptor.DeviceTypeInterceptor;
import com.demo.common.model.Sys;
import com.jfinal.aop.Before;
import com.jfinal.ext.controller.Controller;

/**
 * ASCII码表管理类
 * @author Administrator
 *
 */
public class AsciiContoller extends Controller{
	
	

	public void index(){
		Sys sys = Sys.dao.findById(43);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("ascii.html");
	}

}

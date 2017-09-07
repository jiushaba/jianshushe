package com.demo.docs;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * Http状态码管理类
 * @author Administrator
 *
 */
public class HttpContoller extends Controller{
	
	
	public void index(){
		Sys sys = Sys.dao.findById(40);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("http.html");
	}

}

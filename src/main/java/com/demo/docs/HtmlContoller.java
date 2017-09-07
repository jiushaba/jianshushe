package com.demo.docs;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;

/**
 * Html转义字符管理类
 * @author Administrator
 *
 */
public class HtmlContoller extends Controller{
	
	public void index(){
		Sys sys = Sys.dao.findById(42);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("html.html");
	}

}

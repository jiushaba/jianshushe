package com.demo.regex;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * 正则表达式管理类
 * @author Administrator
 *
 */
public class RegexController extends Controller{
	/**
	 * 正则测试方法
	 */
	public void test (){
		Sys sys = Sys.dao.findById(37);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("test.html");
	}
	
	/**
	 * 正则参考方法
	 */
	public void docs(){
		Sys sys = Sys.dao.findById(44);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("docs.html");
	}

}

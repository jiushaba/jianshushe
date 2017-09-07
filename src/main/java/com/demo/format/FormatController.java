package com.demo.format;

import org.json.XML;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * 代码格式化管理类
 * @author Administrator
 *
 */
public class FormatController extends Controller{
	
	/**
	 * js格式化方法
	 */
	public void js(){
		Sys sys = Sys.dao.findById(31);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("js.html");
	}
	
	/**
	 * html格式化方法
	 */
	public  void  html(){
		Sys sys = Sys.dao.findById(32);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("html.html");
	}
	
	/**
	 * css格式化方法
	 */
	public void css(){
		Sys sys = Sys.dao.findById(33);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("css.html");
	}
	/**
	 * json格式化方法
	 */
	public void json(){
		Sys sys = Sys.dao.findById(34);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("json.html");
	}
	/**
	 * xml格式化方法
	 */
	public void xml(){
		Sys sys = Sys.dao.findById(35);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("xml.html");
	}
	
	/**
	 * sql格式化方法
	 */
	public void sql(){
		Sys sys = Sys.dao.findById(36);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("sql.html");
	}

}

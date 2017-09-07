package com.demo.front;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * 前端工具管理类
 * @author Administrator
 *
 */
public class FrontController extends Controller{
	/**
	 * 调色板方法
	 */
	public void color(){
		Sys sys = Sys.dao.findById(7);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("index.html");
	}
	/**
	 * RGB转16进制方法
	 */
	public void hex(){
		
		Sys sys = Sys.dao.findById(8);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("hex.html");
	}
	
	/**
	 * px转rem方法
	 */
	public void rem(){
		Sys sys = Sys.dao.findById(9);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("rem.html");
	}
	/***
	 * 在线MarkDown编辑器方法
	 * 
	 */
	public void markdown(){
		Sys sys = Sys.dao.findById(10);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("markdown.html");
	}

}

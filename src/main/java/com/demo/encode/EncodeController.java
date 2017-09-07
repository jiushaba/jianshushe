package com.demo.encode;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;


/**
 * 编码解码控制类
 * @author Administrator
 *
 */
public class EncodeController extends Controller{
	
	
	public void url(){
		Sys sys = Sys.dao.findById(14);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("url.html");
	}
	
	
	public void html(){
		Sys sys = Sys.dao.findById(15);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("html.html");
		
	}
	
	public void ascii(){
		Sys sys = Sys.dao.findById(16);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("ascii.html");
		
	}
	
	public void utf8(){
		Sys sys = Sys.dao.findById(17);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("utf8.html");
		
	}
	
	public void unicode(){
		Sys sys = Sys.dao.findById(18);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("unicode.html");
		
	}

}

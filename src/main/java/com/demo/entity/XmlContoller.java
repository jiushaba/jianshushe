package com.demo.entity;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;


/***
 * xml生成实体管理类
 * @author Administrator
 *
 */
public class XmlContoller extends Controller{
	
	public void index(){
		Sys sys = Sys.dao.findById(12);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("xml.html");
	}

}

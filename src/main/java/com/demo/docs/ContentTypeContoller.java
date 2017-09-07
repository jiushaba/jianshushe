package com.demo.docs;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * Content-Type管理类
 * @author Administrator
 *
 */
public class ContentTypeContoller extends Controller{
	
	public void index(){
		Sys sys = Sys.dao.findById(41);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("contenttype.html");
	}

}

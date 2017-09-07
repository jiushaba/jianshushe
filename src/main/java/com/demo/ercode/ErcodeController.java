package com.demo.ercode;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * 二维码生成管理类
 * @author Administrator
 *
 */
public class ErcodeController extends Controller{
	
	public void index(){
		Sys sys = Sys.dao.findById(38);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("create.html");
	}

}

package com.demo.encrypt;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
import com.util.MD5Tools;

public class EncryptController extends Controller{
	
	public void md5(){
		Sys sys = Sys.dao.findById(19);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("md5.html");
	}
	
	public void base64(){
		Sys sys = Sys.dao.findById(20);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("base64.html");
	}
	
	public void image64(){
		Sys sys = Sys.dao.findById(21);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("image64.html");
	}

	public void  filemd5 (){
		Sys sys = Sys.dao.findById(22);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("filemd5.html");
	}

	/**
	 * 字符串转md5
	 */
	public void  stringToMd5(){
		String text=getPara("text");
		boolean is = getParaToBoolean("half");
		if (is) {			
			renderJson(new Response(true,MD5Tools.encrypt16(text)));
		}else {
			renderJson(new Response(true,MD5Tools.encrypt32(text)));
		}
		
	}

}

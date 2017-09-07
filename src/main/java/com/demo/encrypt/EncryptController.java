package com.demo.encrypt;

import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
import com.util.MD5Tools;

public class EncryptController extends Controller{
	
	public void md5(){
		render("md5.html");
	}
	
	public void base64(){
		render("base64.html");
	}
	
	public void image64(){
		render("image64.html");
	}
	
	/**
	 * 转md5
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

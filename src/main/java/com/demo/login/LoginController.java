package com.demo.login;

import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
/**
 * 后台登陆管理类
 * @author Administrator
 *
 */
public class LoginController extends Controller{
	public void index(){
		render("index.html");
	}
	
	public void  toLogin(){
		render("index.jsp");
	}
}

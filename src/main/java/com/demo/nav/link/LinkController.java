package com.demo.nav.link;

import com.jfinal.ext.controller.Controller;
/**
 * 友情链接管理方法
 * @author Administrator
 *
 */
public class LinkController extends Controller{
	
	public void index(){
		render("link.html");
	}

}

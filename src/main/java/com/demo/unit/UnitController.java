package com.demo.unit;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
/**
 * 单位转换管理类
 * @author Administrator
 *
 */
public class UnitController extends Controller{
	/**
	 * 进制转换方法
	 */
	public void binary(){
		Sys sys = Sys.dao.findById(29);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("binary.html");
	}
	
	/**
	 * 时间换算方法
	 */
	public void time(){
		Sys sys = Sys.dao.findById(30);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("time.html");
	}
	
	
}

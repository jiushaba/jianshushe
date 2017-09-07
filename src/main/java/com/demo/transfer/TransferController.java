package com.demo.transfer;

import java.time.chrono.JapaneseChronology;
import java.util.UUID;

import com.demo.common.model.Sys;
import com.jfinal.ext.controller.Controller;
import com.jfinal.ext.model.Response;
/**
 * 字符转换管理类
 * @author Administrator
 *
 */
public class TransferController extends Controller{
	
	/**
	 * 全角半角方法
	 */
	public void dbc(){
		Sys sys = Sys.dao.findById(23);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("dbc.html");
	}
	/**
	 * 大小写转换方法
	 */
	public void upper(){
		Sys sys = Sys.dao.findById(24);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("upper.html");
	}
	/**
	 * Unix时间戳方法
	 */
	public void unix(){
		Sys sys = Sys.dao.findById(25);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("unix.html");
	}
	/**
	 * 字符长度方法
	 */
	public void len(){
		Sys sys = Sys.dao.findById(26);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("len.html");
	}
	/**
	 * GUID
	 */
	public void guid(){
		Sys sys = Sys.dao.findById(27);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("guid.html");
	}
	/**
	 * URL参数格式化方法
	 */
	public void url(){
		Sys sys = Sys.dao.findById(28);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("url.html");
	}
	
	/**
	 * GUID生成方法
	 */
	public void  guidquery(){
		renderJson(new Response(true,UUID.randomUUID().toString()).toJson());		
	}
}

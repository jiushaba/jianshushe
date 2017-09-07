package com.demo.common.Interceptor;

import com.demo.common.model.Sys;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
/**
 * 判断是手机访问还是电脑访问，如果是手机访问跳转到401页面，提示电脑访问
 * @author Administrator
 *
 */
public class DeviceTypeInterceptor implements Interceptor{

	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		String ua = inv.getController().getRequest().getHeader("User-Agent");				
		System.out.println(ua);
		if(ua.indexOf("Android") != -1){
			inv.getController().redirect("/error/401.htm");
		}else if(ua.indexOf("iPhone") != -1 || ua.indexOf("iPad") != -1){
			inv.getController().redirect("/error/401.htm");
		}else {
			inv.invoke();
		}
	}

}

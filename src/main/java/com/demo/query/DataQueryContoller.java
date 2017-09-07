package com.demo.query;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.demo.common.model.Sys;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.model.Response;
import com.util.SystemUtils;
/**
 * 本机ip方法
 * @author Administrator
 *
 */
public class DataQueryContoller extends Controller{

	public void index(){	
		Sys sys = Sys.dao.findById(1);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		String ua = getRequest().getHeader("User-Agent");
		String userIp =SystemUtils.getIpAddr(getRequest());//用户ip地址
		String browserType=SystemUtils.getRequestBrowserInfo(getRequest());
		String systemInfo=SystemUtils.getRequestSystemInfo(getRequest());
		String hostName =SystemUtils.getHostName(userIp);
		Locale  bianma = getRequest().getLocale() ;
		String  eString= getRequest().getCharacterEncoding(); 
		System.out.println("userIp:"+userIp+'\n'+"browserType:"+browserType+'\n'+"systemInfo:"+systemInfo+'\n'
				+"hostName:"+hostName+'\n'+
				ua
				);
		
		if(ua.indexOf("Android") != -1){
		   render("404.html");
		}else if(ua.indexOf("iPhone") != -1 || ua.indexOf("iPad") != -1){
		   render("404.html");
		}else{
			
			setAttr("ip", userIp);
			setAttr("browserType", browserType);
			setAttr("systemInfo", systemInfo);
			setAttr("hostName", hostName);
			setAttr("encoding", bianma+"|"+eString);
			setAttr("ua", ua);
			render("index.html");
		}
		
		
	}	
}

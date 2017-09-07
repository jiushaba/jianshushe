package com.demo.query;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.common.model.Sys;
import com.google.gson.JsonObject;
import com.jfinal.ext.controller.Controller;
/**
 * 域名Alexa查询管理类
 * @author Administrator
 *
 */
public class YuMingQueryContoller extends Controller{
	
	public void index() {
		
		Sys sys = Sys.dao.findById(4);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		render("yumingquery.html");
	}
	
	public void query() throws IOException{
		 String yuming =getPara("yuming");
		 URL u=new URL("http://route.showapi.com/24-1?showapi_appid=34571&name="+yuming+"&showapi_sign=c3607f23f95f413695cd205a3d8d0847");
         InputStream in=u.openStream();
         ByteArrayOutputStream out=new ByteArrayOutputStream();
         try {
             byte buf[]=new byte[1024];
             int read = 0;
             while ((read = in.read(buf)) > 0) {
                 out.write(buf, 0, read);
             }
         }  finally {
             if (in != null) {
                 in.close();
             }
         }
         byte b[]=out.toByteArray( );
         System.out.println(new String(b,"utf-8"));
         JSONObject jsonObject = JSONObject.parseObject(new String(b,"utf-8"));        
         String code=jsonObject.getString("showapi_res_code");
         if (code.equals("0")&&code!=null) {
        	 JSONObject jsonObject2 = jsonObject.getJSONObject("showapi_res_body");
        	 renderJson(jsonObject2);
        	 System.out.println(jsonObject2.toString());
		}else {
			JSONObject erro = jsonObject.getJSONObject("showapi_res_error");
			renderJson(erro);
		}
         
	}

}

package com.demo.query;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.common.model.Sys;
import com.google.gson.JsonObject;
import com.jfinal.ext.controller.Controller;
/**
 * 历史上的今天管理类
 * @author Administrator
 *
 */
public class TodayQueryContoller extends Controller {

	public void index() throws IOException {
		Sys sys = Sys.dao.findById(6);
		int i = sys.get("number");
		sys.set("number", i+1).update();
		  URL u=new URL("http://route.showapi.com/119-42?showapi_appid=34571&date=&showapi_sign=c3607f23f95f413695cd205a3d8d0847");
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
          JSONObject jsonObject =JSONObject.parseObject(new String(b,"utf-8"));
          JSONObject jsonObject2 = jsonObject.getJSONObject("showapi_res_body");
          JSONArray jsonArray =jsonObject2.getJSONArray("list");
        setAttr("day",jsonArray);
		render("todayquery.html");
	}
}

package com.demo.common;

import com.demo.barcode.BarcodeController;
import com.demo.common.Interceptor.DeviceTypeInterceptor;
import com.demo.common.model.Sys;
import com.demo.docs.AsciiContoller;
import com.demo.docs.ContentTypeContoller;
import com.demo.docs.HtmlContoller;
import com.demo.docs.HttpContoller;
import com.demo.encode.EncodeController;
import com.demo.encrypt.EncryptController;
import com.demo.entity.JsonContoller;
import com.demo.entity.XmlContoller;
import com.demo.ercode.ErcodeController;
import com.demo.format.FormatController;
import com.demo.front.FrontController;
import com.demo.index.IndexController;
import com.demo.login.LoginController;
import com.demo.nav.link.LinkController;
import com.demo.query.DataQueryContoller;
import com.demo.query.HttpQueryContoller;
import com.demo.query.IpAddressQueryContoller;
import com.demo.query.PhoneQueryContoller;
import com.demo.query.TodayQueryContoller;
import com.demo.query.YuMingQueryContoller;
import com.demo.regex.RegexController;
import com.demo.transfer.TransferController;
import com.demo.unit.UnitController;
import com.jfinal.aop.Before;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * 配置文件
 * @author Administrator
 *
 */
public class DemoConfig extends JFinalConfig {
	
	/**
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 * 
	 * 使用本方法启动过第一次以后，会在开发工具的 debug、run config 中自动生成
	 * 一条启动配置，可对该自动生成的配置再添加额外的配置项，例如 VM argument 可配置为：
	 * -XX:PermSize=64M -XX:MaxPermSize=256M
	 */
	/*public static void main(String[] args) {
		*//**
		 * 特别注意：Eclipse 之下建议的启动方式
		 *//*
		JFinal.start("src/main/webapp", 8088, "/");
	}*/

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.setBaseViewPath("/WEB-INF/");
		me.add("/admin/index",LoginController.class,"/login");
		me.add("/", IndexController.class);	// 第三个参数为该Controller的视图存放路径
		me.add("/query", DataQueryContoller.class,"/dataquery");			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
		me.add("/httpquery", HttpQueryContoller.class, "/httpquery");
		me.add("/ipaddressquery",IpAddressQueryContoller.class,"/ipaddressquery");
		me.add("/yumingquery",YuMingQueryContoller.class,"/yumingquery");
		me.add("/phonequery",PhoneQueryContoller.class,"/phonequery");
		me.add("/todayquery",TodayQueryContoller.class,"/todayquery");
		me.add("/docs/http",HttpContoller.class,"/docs");
		me.add("/docs/contenttype",ContentTypeContoller.class,"/contenttype");
		me.add("/docs/html",HtmlContoller.class,"/html");
		me.add("/docs/ascii",AsciiContoller.class,"/ascii");
		me.add("/entity/json",JsonContoller.class,"/entity/json");
		me.add("/entity/xml",XmlContoller.class,"/entity/xml");
		me.add("/ercode/create",ErcodeController.class,"/ercode");
		me.add("/barcode/create",BarcodeController.class,"/barcode");
		me.add("/link",LinkController.class,"/link");
		me.add("/regex",RegexController.class,"/regex");
		me.add("/front",FrontController.class,"/front");
		me.add("/format",FormatController.class,"/format");
		me.add("/unit",UnitController.class,"/unit");
		me.add("/transfer",TransferController.class,"/transfer");
		me.add("/encode",EncodeController.class,"/encode");
		me.add("/encrypt",EncryptController.class,"/encrypt");
	}
	
	public void configEngine(Engine me) {

	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		loadPropertyFile("a_little_config.txt");
		
		DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"),
				getProperty("user"), getProperty("password"));
				me.add(dp);
				ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
				me.add(arp);
				arp.addMapping("sys_one",Sys.class );
	}

	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {		
		me.add(new DeviceTypeInterceptor());
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
}

package com.itliren.lancher;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import com.itliren.lancher.utils.ConfigUtils;


public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	
	private static int PORT = 8080;
	
	public static void main(String[] args) throws Exception{
		PORT = Integer.parseInt(ConfigUtils.get("server.port"));
        Server server = new Server(PORT);  
        WebAppContext context = new WebAppContext(); 
        //访问项目地址
        context.setContextPath("/");
        //启动的war包
        context.setWar(ConfigUtils.get("war.name"));
        server.setHandler(context);
        server.start();  
        logger.info("服务启动，端口: "+PORT);
        server.join();  
    }
}

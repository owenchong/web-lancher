package com.itliren.launcher.utils;


import org.apache.log4j.Logger;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	
	private static Logger logger = Logger.getLogger(ConfigUtils.class);
    
    private static Properties props;
    
	static{
        try{
            InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
            props = new Properties();
            props.load(in);
        }catch(Exception e){
            logger.error(e);
        }
	}
	
    public static String get(String key){
        return props.getProperty (key);
    }
	
}



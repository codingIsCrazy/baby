package com.baby.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Contants {
	
	public final static String SQUARE_IMG = "";
	public final static String CONTACT_IMG = "";
	
	
	public static String ServiceIP = "localhost";
	//public static String ServiceIP = "10.172.7.46";
	static{
		 try {
			String ip = InetAddress.getLocalHost().getHostAddress();			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 RedisUtils.initRadis();
	}
	
	
	
}

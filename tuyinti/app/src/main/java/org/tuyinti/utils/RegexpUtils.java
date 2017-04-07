package org.tuyinti.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegexpUtils
 * @Description: TODO  车蛋验证工具
 * @author FH 
 * @date 2015年3月27日 上午11:41:35
 * 
*/

public class RegexpUtils {
	
	 
	/** 
	 * @author FH
	 * @Description: 验证4-8中文
	 * @param str     
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isChinese(String str) {  
	        String regex = "^[\u4e00-\u9fa5]{2,8}$";  
	        return match(regex, str);  
	 }
	 
	 /** 
	 * @author FH
	 * @Description: 验证4-16英文
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isEngilsh(String str){
		    String regex = "^[a-zA-Z]{4,16}$";
		    return match(regex,str);
	 };
	 
	 /** 
	 * @author FH
	 * @Description: 验证是数字
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isNumber(String str){
		   String regex ="^[\\d]*";
		   return match(regex,str);
	 };
	 
	 /** 
	 * @author FH
	 * @Description: TODO  验证昵称
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isNickName(String str){
		 String regex = "^([\u4e00-\u9fa5]{2,8})||([a-zA-Z]{4,16})$";
		 return match(regex, str);
	 };
	 
	 /** 
	 * @author FH
	 * @Description: TODO   验证手机
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isPhone(String str){
		  String regex = "^[1][345678]\\d{9}$";
		  return match(regex,str);
	 };
	 
	 /** 
	 * @author FH
	 * @Description: TODO  验证邮箱
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isEmail(String str){
          String regex = "^[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?$";
          return match(regex,str);
	 };
	 
	/** 
	 * @author FH
	 * @Description: TODO  验证QQ
	 * @param str
	 * @return boolean 
	 * @throws:throws
	*/ 
	
	public static boolean isQQ(String str){
		  String regex = "^\\d{4,14}$";
		  return match(regex,str);
	};
	 
	 private static boolean match(String regex, String str){  
	        Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(str);  
	        return matcher.matches();  
	 }; 

	 
}

package com.xinyiglass.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author david
 *	采用MD5加密方式进行密码加密处理
 */
public class MD5Utils {
	//盐值
	public static final String salt="@x@y@g@";
	
	public static String getMd5Pwd(String inStr,String salt){
		MessageDigest md5 = null;
		try {
			md5=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());  
			e.printStackTrace();
			return "";  
		}
		//添加盐值
		if(salt!=null){
	        	inStr = inStr +salt;
	        }
		 char[] charArray = inStr.toCharArray();  
	     byte[] byteArray = new byte[charArray.length]; 
	     for (int i = 0; i < charArray.length; i++)  
	            byteArray[i] = (byte) charArray[i];  
	        byte[] md5Bytes = md5.digest(byteArray);  
	        
	        StringBuffer hexValue = new StringBuffer();  
	        for (int i = 0; i < md5Bytes.length; i++){  
	            int val = ((int) md5Bytes[i]) & 0xff;  
	            if (val < 16)  
	                hexValue.append("0");  
	            hexValue.append(Integer.toHexString(val));  
	        }  
	        return hexValue.toString(); 		
	}
	
	//不添加盐值 一次加密
    public static String getMd5Pwd(String inStr){  
        return getMd5Pwd(inStr,null);
    }  
    
    //不添加盐值 多次加密
    public static String getMd5Pwd(String inStr,int times){  
    	String hexValue = null;
    	for(int j = 0;j<times;j++){
    		if(j==0){
    			hexValue = getMd5Pwd(inStr);
    		}else{
    			hexValue = getMd5Pwd(hexValue);
    		}
    	}
    	return hexValue;
    }
    
    //添加盐值 多次加密
    public static String getMd5Pwd(String inStr,int times,String salt){  
    	String hexValue = null;
    	for(int j = 0;j<times;j++){
    		if(j==0){
    			hexValue = getMd5Pwd(inStr,salt);
    		}else{
    			hexValue = getMd5Pwd(hexValue);
    		}
    	}
    	return hexValue;
    }
    
    public static void main(String args[]){
    	
    	String inStr="159753";
    	int times=20;
    	System.out.println("加密前:"+inStr);
    	System.out.println("MD5不加盐加密一次:"+getMd5Pwd(inStr,null));
    	System.out.println("MD5加盐加密一次:"+getMd5Pwd(inStr,salt));	
    	System.out.println("MD5不加盐加密三次:"+getMd5Pwd(inStr, times));
    	System.out.println("MD5加盐加密三次:"+getMd5Pwd(inStr,times,salt));
    }
}

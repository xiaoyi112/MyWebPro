package com.xinyiglass.Test;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
 

import org.junit.Test;

import net.sf.json.JSONObject;
/**
*NBA赛事调用示例代码 － 聚合数据
*在线接口文档：http://www.juhe.cn/docs/92
**/
public class NBA {
	
	 
	public static class JuheDemo {
	    public static final String DEF_CHATSET = "UTF-8";
	    public static final int DEF_CONN_TIMEOUT = 30000;
	    public static final int DEF_READ_TIMEOUT = 30000;
	    public static final String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	 
	    //配置您申请的KEY
	    public static final String APPKEY ="4c32666de5e14e6193908f2154a1230a";
	 
	    //1.NBA常规赛赛程赛果
	    @Test				
	    public void getRequest1(){
	        String result =null;
	        String url ="http://op.juhe.cn/onebox/basketball/nba";//请求接口地址
	        Map params = new HashMap();//请求参数
	            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
	            params.put("dtype","");//返回数据的格式,xml或json，默认json
	 
	        try {
	            result =net(url, params, "GET");
	            JSONObject object = JSONObject.fromObject(result);
	            if(object.getInt("error_code")==0){
	                System.out.println(object.get("result"));
	            }else{
	                System.out.println(object.get("error_code")+":"+object.get("reason"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    //2.球队赛程赛事查询
	    @Test
	    public  void getRequest2(){
	        String result =null;
	        String url ="http://op.juhe.cn/onebox/basketball/team";//请求接口地址
	        Map params = new HashMap();//请求参数
	            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
	            params.put("dtype","json");//返回数据的格式,xml或json，默认json
	            params.put("team","勇士");//球队名称
	 
	        try {
	            result =net(url, params, "GET");
	            JSONObject object = JSONObject.fromObject(result);
	            if(object.getInt("error_code")==0){
	                System.out.println(object.get("result"));
	            }else{
	                System.out.println(object.get("error_code")+":"+object.get("reason"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    //3.球队对战赛赛程查询
	    public static void getRequest3(){
	        String result =null;
	        String url ="http://op.juhe.cn/onebox/basketball/combat";//请求接口地址
	        Map params = new HashMap();//请求参数
	            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
	            params.put("dtype","");//返回数据的格式,xml或json，默认json
	            params.put("hteam","");//主队球队名称
	            params.put("vteam","");//客队球队名称
	 
	        try {
	            result =net(url, params, "GET");
	            JSONObject object = JSONObject.fromObject(result);
	            if(object.getInt("error_code")==0){
	                System.out.println(object.get("result"));
	            }else{
	                System.out.println(object.get("error_code")+":"+object.get("reason"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	    public static void main(String[] args) {
	 
	    }
	 
	    /**
	     *
	     * @param strUrl 请求地址
	     * @param params 请求参数
	     * @param method 请求方法
	     * @return  网络请求字符串
	     * @throws Exception
	     */
	    public static String net(String strUrl, Map params,String method) throws Exception {
	        HttpURLConnection conn = null;
	        BufferedReader reader = null;
	        String rs = null;
	        try {
	            StringBuffer sb = new StringBuffer();
	            if(method==null || method.equals("GET")){
	                strUrl = strUrl+"?"+urlencode(params);
	            }
	            URL url = new URL(strUrl);
	            conn = (HttpURLConnection) url.openConnection();
	            if(method==null || method.equals("GET")){
	                conn.setRequestMethod("GET");
	            }else{
	                conn.setRequestMethod("POST");
	                conn.setDoOutput(true);
	            }
	            conn.setRequestProperty("User-agent", userAgent);
	            conn.setUseCaches(false);
	            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
	            conn.setReadTimeout(DEF_READ_TIMEOUT);
	            conn.setInstanceFollowRedirects(false);
	            conn.connect();
	            if (params!= null && method.equals("POST")) {
	                try {
	                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
	                        out.writeBytes(urlencode(params));
	                } catch (Exception e) {
	                    // TODO: handle exception
	                }
	            }
	            InputStream is = conn.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
	            String strRead = null;
	            while ((strRead = reader.readLine()) != null) {
	                sb.append(strRead);
	            }
	            rs = sb.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                reader.close();
	            }
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	        return rs;
	    }
	 
	    //将map型转为请求参数型
	    public static String urlencode(Map<String,Object>data) {
	        StringBuilder sb = new StringBuilder();
	        for (Map.Entry i : data.entrySet()) {
	            try {
	                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	}
}

package com.xinyiglass.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * @author david
 *	自写项目的controller基类
 *	包含一些常用变量的使用方法
 */
public class BaseController {
	
	public static String CHAR_ENCODE = "utf-8";
	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Long userid;
	protected Long loginid;
	
	
	//初始化
	@ModelAttribute
	public void SetResAndRep(HttpServletRequest request,HttpServletResponse response){
		this.request=request;
		this.response=response;
		this.session=request.getSession();
		response.setContentType("text/html;charset="+CHAR_ENCODE);  
		userid=(Long) session.getAttribute("USER_ID");
		loginid=(Long) session.getAttribute("LOGIN_ID");
	}
	
	
	/**
	 * @return
	 * 获取request
	 */
	public HttpServletRequest getRequest(){
		
		return request;
	}
	
	/**
	 * @return
	 * 获取response
	 */
	public HttpServletResponse getResponse(){
		return response;
	}
	/**
	 * @return
	 * 获取session
	 */
	public HttpSession getSession(){
		return session;
	}
	
	public String getParam(String text){
		return request.getParameter(text);
	}
	
	public void reString(Object object) throws IOException{
		JSONObject fromObject = JSONObject.fromObject(object);
		response.getWriter().print(fromObject);
	}
	
	public JSONObject toJson(Object object){
		
		return JSONObject.fromObject(object);
	}
}

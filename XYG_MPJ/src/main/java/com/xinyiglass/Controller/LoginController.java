package com.xinyiglass.Controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xinyiglass.beans.User;
import com.xinyiglass.service.LoginService;

@Controller
public class LoginController extends BaseController{
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("")
	public String reLogin(){
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin() throws Exception{		
		 User user=new User();	 			
		 BeanUtils.populate(user, getRequest().getParameterMap());
		
		 User loginedUser = loginService.doLogin(user);
		 if(loginedUser!=null&&!loginedUser.equals("")){
			 getSession().setAttribute("user", loginedUser);
		 }else{
			 getSession().setAttribute("errorMsg", "用户名或密码错误");
			 return "login";
		 }
		 return "index";
	}
	
	@RequestMapping("loginOff")
	public String loginOff(){
			
	  User user=(User) getSession().getAttribute("user");
	  
	  if(user!=null&&!user.equals("")){
		  
		  getSession().removeAttribute("user");
		  	
	  }
	  return "login";
	}
}

package com.xinyiglass.Controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin() throws Exception{		
		 User user=new User();	 			
		 BeanUtils.populate(user, getRequest().getParameterMap());
		
		 User loginedUser = loginService.doLogin(user);
		 getSession().setAttribute("user", loginedUser);
		 
		 return "index";
	}
}

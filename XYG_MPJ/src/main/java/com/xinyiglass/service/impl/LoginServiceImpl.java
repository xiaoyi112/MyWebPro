package com.xinyiglass.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinyiglass.beans.User;
import com.xinyiglass.mapper.LoginMapper;
import com.xinyiglass.service.LoginService;


@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;
	@Override
	public User doLogin(User user){
		// TODO Auto-generated method stub
		return loginMapper.doLogin(user.getUserName(),user.getPassword());
	
	}	
}

package com.xinyiglass.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xinyiglass.beans.User;

@Repository(value="loginMapper")
public interface LoginMapper {

	User doLogin(@Param("username") String username,@Param("password") String password);
	
}

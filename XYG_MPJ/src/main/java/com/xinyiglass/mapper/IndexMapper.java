package com.xinyiglass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyiglass.beans.Menu;

public interface IndexMapper {

	List<Menu> getMenu(@Param("menuid")int menuid);
	
}

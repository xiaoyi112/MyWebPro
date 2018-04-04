package com.xinyiglass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyiglass.beans.Menu;
import com.xinyiglass.mapper.IndexMapper;
import com.xinyiglass.service.IndexService;

@Service("indexService")
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexMapper indexMapper;
	
	@Override
	//一级菜单查询
	public List<Menu> getMenu(int menuid) {
		// TODO Auto-generated method stub
		return indexMapper.getMenu(menuid);
	}
}

package com.xinyiglass.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinyiglass.beans.Menu;
import com.xinyiglass.service.IndexService;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController{
	@Autowired
	private IndexService indexService;
	
	//获取菜单栏
	@RequestMapping(value="getMenu",method=RequestMethod.GET)
	public void getMenu(@RequestParam(value="menuId",required=false)String menuId){
		
		HashMap<String, List<Menu>> map=new HashMap<String, List<Menu>>();
		int menuid=1;
		if(menuId!=null&&!menuId.equals("")){
			menuid=Integer.parseInt(menuId);
		}
		
		List<Menu> menuList=new ArrayList<Menu>();
		menuList=indexService.getMenu(menuid);
		
		JSONArray fromObject = JSONArray.fromObject(menuList);
		System.out.println(fromObject);
		
		try {
			getResponse().getWriter().print(fromObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

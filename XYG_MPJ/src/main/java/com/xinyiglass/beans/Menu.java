package com.xinyiglass.beans;

import java.util.List;

public class Menu {
	
	private List<Menu> menuList; //菜单栏下的子菜单
	private int menuId; //菜单栏id
	private String menuName; //菜单栏名称
	private String menuPre; //菜单栏父菜单
	private String menuUrl; //菜单栏链接
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public String getMenuPre() {
		return menuPre;
	}
	public void setMenuPre(String menuPre) {
		this.menuPre = menuPre;
	}
	@Override
	public String toString() {
		return "Menu [menuList=" + menuList + ", menuId=" + menuId
				+ ", menuName=" + menuName + ", menuPre=" + menuPre
				+ ", menuUrl=" + menuUrl + "]";
	}
	
	
}

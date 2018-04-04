/*
 * 	2018.04.03创建,主要用于动态获取菜单栏的读取操作,可根据菜单栏的数据自适应
 * 
 * 
 * 
 * */

//jquery入口函数
$(function(){
	getMenu();
	
	
	
	
})
var html='';	//获取菜单栏列表
function getMenu(){	
	$.ajax({
		method:'GET',
		url:'index/getMenu',
		success:function(data){
			$.each(JSON.parse(data), function(i,n){
				/*html+="<li class='layui-nav-item layui-nav-itemed'>"+
							"<a href='javascript:;' onclick='getRefMenu("+n.menuId+")'>"+n.menuName+"</a>"+
							"<dl class='layui-nav-child'></dl>"+
					  "</li>"*/
				$("ul[class|='layui-nav layui-nav-tree']").append("<li class='layui-nav-item layui-nav-itemed'>" +
						"<a href='javascript:;' onclick='getRefMenu("+n.menuId+")'>"+n.menuName+"</a>" +
						"<dl class='layui-nav-child'></dl></li>")	
				
			})			
		}		
	})
}

function getRefMenu(menuId){
	$.ajax({
		method:'get',
		url:'index/getMenu',
		data:{'menuId':menuId},
		success:function(data){
			console.log(data)
			$.each(JSON.parse(data), function(i,n) {
			$("dl[class|='layui-nav-child']").append("<dd>"+
								"<a data-url='Resource/page/content/first' href='javascript:;' data-id='11' data-title='"+n.menuName+"' class='site-demo-active' data-type='tabAdd' data-filter='listOne'>"+n.menuName+"</a>"+
							"</dd>")
			})
		}
		
	})
}

	
<%@page import="com.fasterxml.jackson.core.io.OutputDecorator"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>"> 
    <title>用户登录</title>
     <!-- 图标cdn引入 -->
    <link rel="stylesheet" href="Resource/css/font-awesome.min.css">
    <link rel="stylesheet" href="Resource/layui/css/layui.css">
  	<script type="text/javascript" src="Resource/js/jQuery-2.1.4.min.js"></script>
  	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="Resource/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="Resource/css/login.css">
    <script type="text/javascript" src="Resource/layui/layui.js"></script>
  </head>
  
  <body>
   <!-- 登录框 -->
   <div style="opacity:1;height:100%">
     <div class="bg"><%out.println(basePath); %></div>
	  <div class="login-page">
	    <div class="login-frame">
	      <div class="top-frame">
	        <span style="font-size:50px;margin-bottom:10px">
		      <i class="fa fa-user-circle-o" aria-hidden="true"></i>
			</span>
	    	<span style="font-size:20px;margin-bottom:10px">客户登录</span>
	      </div>
	      <form role="form" id="loginFrom" name="loginFrom" method="post" action="dologin">
   		    <div class="form-group" style="padding:0 25px">
   		      <label for="username" style="padding-right:1px">
   		        <i class="fa fa-user-o" aria-hidden="true"></i>
   		      </label>
      	      <input type="text" class="form-control" id="username" name="userName" autocomplete="off" placeholder="用户名" required="required"/>
   		    </div>
   		    <div class="form-group" style="padding:0 25px">
   		      <label for="password" style="padding-right:6px">
   		        <i class="fa fa-lock" aria-hidden="true"></i>	
   		      </label>
     	      <input type="text" style="display:none;"/>
      	      <input type="text" class="form-control" id="password" name="password" autocomplete="off" onfocus="this.type='password'" onBlur="if(this.value==null||this.value==''){this.type='text'}" placeholder="密码" required="required"/>
   		      <input type="text" style="display:none;"/>
   		    </div>
   		    <div  class="form-group" style="padding:0 25px">	   
   		      <label for="textMsg" >
   		        <i class="fa fa-key" aria-hidden="true"></i>
			  </label>  		   
   		      <input type="text" id="textMsg" name="textMsg" style="width:120px"  class="form-control textMsg left" autocomplete="off" placeholder="验证码" required="required"/>
   		  	  <input id="getMessage" type="button" class="btn-op pointer" value="获取验证码"/>
   		  	</div>
   		    <input type="hidden" id="lang" name="lang" value="ZHS"/>
			<input id="login" type="submit" class="btn pointer" value="立 即 登 录"/>
			<input type="button" data-select="modify" class="forget-pwd pointer" value="忘记密码？"/>
	    </form>
	    </div>
	  </div>
 </div>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
   	var user=JSON.stringify(data.field);
  });
});
</script>

  </body>
</html>

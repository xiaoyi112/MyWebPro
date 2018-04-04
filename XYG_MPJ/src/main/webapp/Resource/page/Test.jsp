<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="https://cdn.bootcss.com/vue/2.4.2/vue.min.js"></script>
</head>

<body>
	<div id="app">
		<button v-on:click="counter += 1">增加 1</button>
		<p>这个按钮被点击了 {{ counter }} 次。</p>
	</div>

	<script>
		new Vue({
			el : '#app',
			data : {
				counter : 0
			}
		})
	</script>
</body>
</html>

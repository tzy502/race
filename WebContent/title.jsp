<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servlet.RaceControl"%>
<%@ page import="servlet.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="js/WdatePicker.js"></script>
</head>

<body>
	<img src="title.png"> 
	<br>
	<% User user =(User)session.getAttribute("user"); 
if(user.getType()==1||user.getType()==0){
	%>
	欢迎管理员:
	<% }
	else{
		%>
	欢迎用户:
	<% 
	}

%>
	<%=user.getUsername() %>

	<a href="modifypwd.jsp">修改密码</a>
	<a href="modifyuser.jsp">修改个人信息</a>
	<a href="addrace.jsp">添加比赛</a>
	
	
	<a href="index.jsp">返回首页</a>
	<form style="margin:0px;display:inline;" action="quit.do" method="post">
		<input type="submit" value="退出">
	</form>
	<type>
	
	
	<br>
</body>
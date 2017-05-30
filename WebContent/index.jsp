<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
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

	<form action="quit.do" method="post"><input type="submit" value="退出"> 
	</form>
</body>
</html>
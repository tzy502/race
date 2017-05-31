<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="model.Race"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servlet.RaceControl"%>
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

	<a href="modifypwd.jsp">修改密码</a>
	<a href="modifyuser.jsp">修改个人信息</a>
	<a href="addrace.jsp">添加比赛</a>
	<form action="quit.do" method="post">
		<input type="submit" value="退出">
	</form>
	<% List<Race> list =new ArrayList<Race>() ;
	RaceControl rc=new RaceControl();
	list=rc.load();
	if(list.size()!=0){
		out.print("<tr> <th>asdasdasd </th></td>");
		out.print("<tr> <th>12312312 </th></td>");
	}
	%>
	
	
	






</body>
</html>
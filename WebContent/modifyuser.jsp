<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user =(User)session.getAttribute("user");   %> 
	<form action="modifyuser.do" method="post">
		<center>帐号:<%=user.getUserid() %>
		<center>昵称:<input type="text" name="username" value=<%=user.getUsername() %>><br />	
		<center>QQ:<input type="text" name="QQ" value=<%=user.getQQ() %>><br />	
		<center>TEL:<input type="text" name="TEL" value=<%=user.getTEL() %>><br />	
		<center><input type="submit" value="修改"> <input type="reset" value="清空">
	</form>
</body>
</html>


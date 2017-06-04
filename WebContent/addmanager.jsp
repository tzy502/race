<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="title.jsp"%>
<%Race race=(Race)session.getAttribute("race"); %>
<title><%=race.getRacename() %>添加管理员</title>
</head>
<body>
	<form action="addmanager.do" method="post">
	<center>新管理员:<input type="text" name="userid"><br />
	<center><input type="submit" value="添加">、
	<input type="hidden"  value="<%=race.getRaceid() %>" name="raceid">
	</form>
</body>
</html>
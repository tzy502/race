<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="title.jsp"%>
<%Race race=(Race)session.getAttribute("race"); 
%>
<title><%=race.getRacename() %>详情</title>
</head>
<body>
	比赛名：<%=race.getRacename() %><br>
	比赛时间：<%=race.getRaceopendate() %><br>
	比赛地点：<%=race.getRaceaddress() %><br>
	比赛介绍：<%=race.getIntroduction() %><br>
<% BattleManegerControl bmc=new BattleManegerControl();

boolean ismanager= bmc.isracemanger(race.getRaceid(), user.getUserid());
if(ismanager){
	%>
			<form action="raceing.do" method="post">
				<input type="submit" value="下一场">
			</form>
	<%
} %>
<% %>

</body>
</html>
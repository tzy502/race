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
<% BattleManegerControl bmc=new BattleManegerControl();
boolean ismanager= bmc.isracemanger(race.getRaceid(), user.getUserid());
if(ismanager){
	%>

		<a href="modifyrace.jsp">修改比赛</a>
		<a href="addmanager.jsp">添加管理员</a>
		<br>
	<%
} %>

			<form action="join.do" method="post">
				<input type="hidden" value= <%=user.getUserid()%> name="userid">
				<input type="hidden" value= <%=user.getUsername()%> name="username">
				<input type="hidden" value= <%=race.getRaceid() %> name="raceid">
				<input type="submit" value="参加">
			</form>
	比赛名：<%=race.getRacename() %><br>
	比赛时间：<%=race.getRaceopendate() %><br>
	比赛地点：<%=race.getRaceaddress() %><br>
	比赛介绍：<%=race.getIntroduction() %><br>
	参与人员：<br>
	<%List<BattleTable> allplay =(List<BattleTable>)session.getAttribute("allplay"); 
	System.out.print(allplay.size());
	if(allplay!=null){
		%>
		<table border="1">
			<tr>	
				<td>序号</td>			
				<td>用户名</td>
			</tr>
		<%
		for(int i=0;i<allplay.size();i++){
			%>
			<tr>				
				<td><%=i+1 %></td>
				<td><%=allplay.get(i).getUsername() %></td>
			</tr>
			<%
		}
	}
	
	
	%>

</body>
</html>
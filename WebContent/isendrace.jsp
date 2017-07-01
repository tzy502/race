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
	<%=race.getRacename() %>比赛已经结束
	比赛记录
	<%
	List<BattleLog> allbattle =new ArrayList<BattleLog>();
	BattleLogDAO bld=new BattleLogDAO();
	allbattle=bld.searchbyraceid(race.getRaceid());
	%>
	<table border="1">
		<tr>	
			<td>序号</td>			
			<td>用户1</td>
			<td>用户2</td>
			<td>谁赢</td>
		</tr>
	<%
	for(int i=1;i<allbattle.size();i++){
			%>
			<tr>				
				<td><%=i+1 %></td>
				<td><%=allbattle.get(i).getBattleusername1() %></td>
				<td><%=allbattle.get(i).getBattleusername2() %></td>
				<td> 
				<%
				if(allbattle.get(i).getWhowin()==1){
					out.print("玩家1胜利");
				}
				else
					out.print("玩家2胜利");
				
				
				%>
				</td>
			</tr>
			<%
			
	}
	
	%>
</body>
</html>
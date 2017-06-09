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
if(ismanager==true){
	%>
		<form action="raceing.do" method="post">

	<%
} %>

<% 
RaceControl rc=new RaceControl();
List<BattleTable> result =new ArrayList<BattleTable>();
result=(List<BattleTable>)session.getAttribute("battle");
boolean flag=false;
if(result.size()>1){
	%>
	<table border="1">
		<tr>				
			<td>序号</td>
			<td>选手A</td>
			<td>VS</td>
			<td>选手B</td>
			<td>胜负</td>
		</tr>
	<%
	int j=result.size();

	if(j%2!=0){
		j=j-1;
		flag=true;
	}
	int round=0;
	String win;
	for(int i=0;i<j;i=i++){
		round++;
		out.print("<td>第"+round+"场</td>");
		out.print("<td>"+result.get(i).getUsername()+"</td>");
		i++;
		out.print("<td>VS</td>");
		out.print("<td>"+result.get(i).getUsername()+"</td>");
		win="the"+round+"win";
		i++;
		%>
		
		<td>
		<label><input name="<%=win %>" type="radio" value="1" />A胜</label>
		<label><input name="<%=win %>" type="radio" value="2" />B胜</label>		
		</td>	
		<% 
		out.print("</tr>");
	}
	%>
	</table>
<% 
String lucky="-1";
	if(flag==true){
		out.print(" "+result.get(j).getUsername()+"轮空");
		lucky=result.get(j).getUserid();
		%>
		<input type="hidden" value= <%=round%> name="totalrace">
		<input type="hidden" value= <%=lucky%> name="lucky">
		<input type="hidden" value= <%=race.getRaceid()%> name="raceid">
		<% 
	}else{
	%>
		<br>
			<input type="hidden" value= <%=round%> name="totalrace">
		<input type="hidden" value= <%=lucky%> name="lucky">
		<input type="hidden" value= <%=race.getRaceid()%> name="raceid">

	<%
}
	%>				<input type="submit" value="下一场">
			</form>
			<% 

}
else if (result.size()==1){
	out.print("比赛结束 胜利者"+result.get(0).getUsername());
	

}


%>

</body>
</html>
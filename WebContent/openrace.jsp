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

  <nav>
    <div class=" grey lighten-1 nav-wrapper">
      <div class="col s4 offset-s1">
      	你所在位置：
        <a href="index.jsp" class="breadcrumb">首页</a>
        <a href="#" class="breadcrumb">比赛详情</a>
      </div>
    </div>
  </nav>
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
System.out.print("result"+result.size());
if(result.size()>1){
	System.out.print("from jsp");
	%>
	
   <div class="row">
          <div class="col s8  offset-s2">
	 <table class="bordered highlight  responsive-table">
		<tr>				
			<th>序号</th>
			<th>选手A</th>
			<th>VS</th>
			<th>选手B</th>
			<th>胜负</th>
		</tr>
	<%
	int j=result.size();
	String radioid="test";
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
		radioid=radioid+round;
		
		%>
		
		<td>
	      <input name=<%=win %> type="radio" id=<%=radioid %> value="1" />
	      <label for=<%=radioid %>>A胜</label>
	      <input name=<%=win %> type="radio" id=<%=radioid+1 %> value="2" />
	      <label for=<%=radioid+1 %>>B胜</label>
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
<%@ include file="foot.jsp"%>
</body>
</html>
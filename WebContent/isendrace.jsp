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
	<%=race.getRacename() %>比赛已经结束
	比赛记录
	<%
	List<BattleLog> allbattle =new ArrayList<BattleLog>();
	BattleLogDAO bld=new BattleLogDAO();
	allbattle=bld.searchbyraceid(race.getRaceid());
	%>
		       <div class="row">
          <div class="col s8  offset-s2">
	<table class="bordered highlight  responsive-table">
		<tr>	
			<th>序号</th>			
			<th>用户1</th>
			<th>用户2</th>
			<th>谁赢</th>
		</tr>
	<%
	for(int i=1;i<allbattle.size();i++){
			%>
			<tr>				
				<td><%=i %></td>
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
	</table></div></div>
	<%@ include file="foot.jsp"%>
</body>
</html>
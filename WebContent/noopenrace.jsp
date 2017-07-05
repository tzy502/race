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

 %>
  <nav>
    <div class=" grey lighten-1 nav-wrapper">
      <div class="col s4 offset-s1">
      	你所在位置：
        <a href="index.jsp" class="breadcrumb">首页</a>
        <a href="#" class="breadcrumb">比赛详情</a>
      </div>
    </div>
  </nav>
  
        <div class="col s4 m6  offset-s2">
        
          <div class="card blue-grey darken-1 ">
           <div class="z-depth-5">
            <div class="card-content white-text ">
           
              <span class="card-title">比赛名：<%=race.getRacename() %><br></span>
              	 <p>比赛时间：<%=race.getRaceopendate() %></p>
				 <p>比赛地点：<%=race.getRaceaddress() %></p>
				 <p>比赛介绍：<%=race.getIntroduction() %></p>
            </div>
			<form action="join.do" method="post">
				<input type="hidden" value= <%=user.getUserid()%> name="userid">
				<input type="hidden" value= <%=user.getUsername()%> name="username">
				<input type="hidden" value= <%=race.getRaceid() %> name="raceid">
				<input type="submit" class="waves-effect waves-light btn offset-s1" value="参加">
			</form>
              <div class="card-action">
				<%
				if(ismanager){
					%>


						<a href="modifyrace.jsp">修改比赛</a>
						<a href="addmanager.jsp">添加管理员</a>
						
							<form action="openrace.do" method="post">
								<input type="hidden" value= <%=race.getRaceid() %> name="raceid">
								<input type="submit" class="waves-effect waves-light btn" value="比赛开始">
							</form>
						
						
						
					<%
				}
				
				%>
            </div>      
          </div>
        </div>
  </div>




	

	参与人员：<br>
	<%List<BattleTable> allplay =(List<BattleTable>)session.getAttribute("allplay"); 
	System.out.print(allplay.size());
	if(allplay!=null){
		%>
   <div class="row">
          <div class="col s8  offset-s2">
	 <table class="bordered highlight  responsive-table">
			<tr>	
				<th>序号</th>			
				<th>用户名</th>
			</tr>
		<%
		for(int i=0;i<allplay.size();i++){
			%>
			<tr>				
				<td><%=i+1 %></td>
				<td><%=allplay.get(i).getUsername() %></td>
			</tr>
			</table></div></div>
			<%
		}
	}
	
	
	%>

</body>
<%@ include file="foot.jsp"%>
</html>
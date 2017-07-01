<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servlet.RaceControl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<%@ include file="title.jsp"%>
<body>

	<% List<Race> list =new ArrayList<Race>() ;
	RaceControl rc=new RaceControl();
	list=rc.load();
	
	String type=null;
	%>
	       <div class="row">
          <div class="col s8  offset-s2">
	
	<p>现在有的比赛有:</p>
	
	<%
	if(list.size()!=0){
		%>
		 <table class="bordered highlight centered responsive-table">
		  <thead>
          <tr>
				<th>比赛名</th>
				<th>比赛地址</th>
				<th>比赛类型</th>
				<th>比赛介绍</th>
				<th>比赛时间</th>
				<th>比赛状态</th>
				<th>详情</th>
          </tr>
        </thead>
        <tbody>
		<%
		for(int i=0;i<list.size();i++){
			%>

			<tr>
			<%
			out.print("<td>"+list.get(i).getRacename()+"</td>");
			out.print("<td>"+list.get(i).getRaceaddress()+"</td>");
			switch (list.get(i).getRacetype()){
			case 1 : {type="单败"; break;}
			case 2 : {type="双败"; break;}
			case 3 : {type="瑞士轮"; break;}
			case 4 : {type="KOF"; break;}
			case 5 : {type="征服"; break;}
			}
			out.print("<td>"+type+"</td>");
			out.print("<td>"+list.get(i).getIntroduction()+"</td>");
			out.print("<td>"+list.get(i).getRaceopendate()+"</td>");
			String state=null;
			switch (list.get(i).getRacestate()){
				case 1 : {state="还未开始"; break;}
				case 2 : {state="开始"; break;}
				case 3 : {state="已经结束"; break;}
			}
			out.print("<td>"+state+"</td>");
			%>			
			<td>
			<form action="detial.do" method="post">
				<input type="hidden" value= <%=list.get(i).getRaceid()%> name="raceid">
				  <button class="btn waves-effect waves-light blue lighten-1" type="submit" name="action">详情
   					 <i class="material-icons right">send</i>
  					</button>
			</form>
			
			</td>
			</tr>	
			<%
		}
		%>
		</tbody>
		</table>
		</div>
		<%
		
	}
	else{
		out.print("暂无<br>");
	}
	%>
	
	
	






</body>
</html>
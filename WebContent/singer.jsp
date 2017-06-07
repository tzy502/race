<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servlet.RaceControl"%>
<%@ page import="servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<%
	RaceControl rc=new RaceControl();
	Race race=(Race)session.getAttribute("race"); 
	List<BattleTable> result =new ArrayList<BattleTable>();
	result=(List<BattleTable>)session.getAttribute("battle");
	boolean flag=false;
	if(result.size()!=0){
		%>
		<table border="1">
			<tr>				
				<td>序号</td>
				<td>A</td>
				<td>VS</td>
				<td>B</td>

			</tr>
		<%
		int j=result.size();

		if(j%2!=0){
			j=j-1;
			flag=true;
		}
		for(int i=0;i<j;i++){
			out.print("<td>"+result.get(i).getUsername()+"</td>");
			out.print("<td>VS</td>");
			i=i+1;
			out.print("<td>"+result.get(i).getUsername()+"</td>");
		}
		%>
		</table>
	<% 
		if(flag==true){
			out.print(result.get(j+2)+"轮空");
		}
	}

	%>
	
	<input type="checkbox" name= a>
</body>
</html>
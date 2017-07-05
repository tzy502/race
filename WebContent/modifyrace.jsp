<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="title.jsp"%>
<%Race race=(Race)session.getAttribute("race"); %>
<title><%=race.getRacename() %>修改</title>
</head>
<body>
	<form action="addrace.do" method="post">
		<center>比赛名:<input type="text" name="racename" value=<%=race.getRacename() %>><br />
		<center>赛制:
		<select name = "racetype">  
		<%int type=race.getRacetype(); %>
		  <option value="1">单败</option>  
		  <option value="2">双败</option>  
		  <option value="3">瑞士轮</option>
		 <option value="4">KOF</option>    
		 <option value="5">征服</option>
		 
		</select>  
		<center>比赛地点:<input type="text" name="raceaddress"value=<%=race.getRaceaddress() %>><br />
		<center>比赛介绍:<input type="text" name="introduction" value=<%=race.getIntroduction() %>><br />
		<center>比赛时间: <input id="" name="raceopendate" class="Wdate"  value=<%=race.getRaceopendate().toString()%> onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate:'<%=race.getRaceopendate().toString() %>',readOnly:true})" />
		<center><input type="submit" value="登陆">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="servlet.RaceControl"%>
<%@ page import="servlet.*"%>
<%@ page import="DAO.*"%>
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="js/WdatePicker.js"></script>
</head>

<body>
<center><img src="title.png"></center>
	
	
	<% 
	String usertotal=null;
	User user=null;
	user =(User)session.getAttribute("user"); 
	if(user==null){
		request.setAttribute("errormsg","请登录");
		%>	
		<script language="javascript" type="text/javascript">
		window.location='/login.jsp';
		</script>
		<%
		
	}
	else{
		if(user.getType()==1||user.getType()==0){
			usertotal="欢迎管理员:";
		}	
		else{
			usertotal="欢迎用户:";	
		}
	usertotal=usertotal+user.getUsername();
	}

%>

<nav>
    <div class=" blue lighten-1 nav-wrapper">
      <a><%=usertotal %></a>	
      <ul id="nav-mobile" class=" right hide-on-med-and-down">
        <li><a href="modifypwd.jsp">修改密码</a></li>
        <li><a href="modifyuser.jsp">修改个人信息</a></li>
        <li><a href="addrace.jsp">添加比赛</a></li>
        <li>
		<form  action="quit.do" method="post">
			<input class="blue lighten-1 nav-wrapper waves-effect waves-light btn-large" type="submit" value="退出">
		</form>
        </li>
      </ul>

    </div>
  </nav>
	

	<type>
	
	
	<br>
</body>
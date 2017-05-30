<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
</head>
<body>
	<%
   String errmsg=(String)request.getAttribute("errormsg");
   if(errmsg!=null){
	request.removeAttribute("errormsg");
 //   out.println(errmsg);
    %>
  	<script type="text/javascript" language="javascript">
		alert("<%=errmsg%>");                                            // 弹出错误信息
		javascript:history.go(-1);                      // 跳转到登录界面
	</script>	
<% 
   }
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加比赛</title>
</head>
<%@ include file="title.jsp"%>
<body>

<nav>
    <div class=" grey lighten-1 nav-wrapper">
      <div class="col s4 offset-s1">
      	你所在位置：
        <a href="index.jsp" class="breadcrumb">首页</a>
        <a href="#" class="breadcrumb">添加比赛</a>
      </div>
    </div>
  </nav>
  <div class="row">
  <center>
	<form action="addrace.do" method="post">

		
		<div class="row">
				<div class="input-field col s4 offset-s4">
						比赛名:<input type="text"  name="racename">						
				</div>
			</div>
						<div class="row">
							赛制:
		<div class="row">
	
		<select name = "racetype" class="browser-default col s4 offset-s4">  	
		<option value="" disabled selected></option>
		  <option value="1">单败</option>  
		  <option value="2">双败</option>  
		  <option value="3">瑞士轮</option>
		 <option value="4">KOF</option>    
		 <option value="5">征服</option>
		</select>  
		
	</div>
	</div>
	
			<div class="row">
				<div class="input-field col s4 offset-s4">
						比赛地点:<input type="text" name="raceaddress">					
				</div>
			</div>	
			<div class="row">
				<div class="input-field col s4 offset-s4">
						比赛介绍:<input type="text" name="introduction" size="70"><br />					
				</div>
			</div>		
				<div class="row">
				<div class="col s4 offset-s4">
						比赛时间: <input id="" name="raceopendate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" />				
				</div>
			</div>	
		
		<input class="waves-effect waves-light btn" type="submit" value="添加">
		
		<input type="reset" class="waves-effect waves-light btn" value="清空">
	</form>
	</center>
	</div>
</script> 
</body>
<%@ include file="foot.jsp"%>

</html>

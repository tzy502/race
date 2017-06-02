<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>  
  <head>  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>  
    <title>My97DatePicker日期控件使用</title>  
  </head>  
  <body>  
    <center>  
        <h2>My97DatePicker日期控件的使用</h2>  
    </center>  
    
    <input id="d121" type="Wdate" onfocus="WdatePicker({})"/>
    
            基本用法：  
    <input id="" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" /><br><br>  
            
            只能选择今天以前的日期：  
    <input id="" class="Wdate" onfocus="WdatePicker({readOnly:true,maxDate:'%y-%M-%d'})" /><br><br>         
             
           使用运算表达式 只能选择 20小时前 至 30小时后 的日期    
    <input id="" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d {%H-20}:%m:%s',maxDate:'%y-%M-%d {%H+30}:%m:%s'})" /><br><br>              
              
            开始，结束日期：<!-- $dp.$ 相当于 document.getElementById 函数. -->  
    <input id="sdate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,maxDate:'#F{$dp.$D(\'edate\')}'})" />  
    -  
    <input id="edate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'sdate\')}',startDate:'#F{$dp.$D(\'sdate\',{d:+1})}'})" /><br><br>  
       
  </body>  
  
</html> 
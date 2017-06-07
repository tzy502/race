/**
 * 
 */
/**
 * @author lenovo
 *
 */
package waste;

/*-   %>
window.location='login.jsp' ;    
 <%*/

/*
 * 	<error-page>
		<error-code>404</error-code>
		<location>/error.jsp</location>
	</error-page>
		<error-page>
		<error-code>500</error-code>
		<location>/error.jsp</location>
	</error-page>
 * 
 * 
 * 
 * 	<%
	List<Race> result =new ArrayList<Race>();
	result=(List<Race>)session.getAttribute("battle");
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
			out.print("<td>"+result.get(i).getRacename()+"</td>");
			out.print("<td>VS</td>");
			i=i+1;
			out.print("<td>"+result.get(i).getRacename()+"</td>");
		}
		%>
		</table>
	<% 
		if(flag==true){
			out.print(result.get(j+2)+"轮空");
		}
	}


switch (race.getRacetype()) {
case 1:{%><%@ include file="singer.jsp"%><%;break;}
case 2:{break;}
case 3:{break;}
case 4:{break;}
case 5:{break;}
	%>
	
 */
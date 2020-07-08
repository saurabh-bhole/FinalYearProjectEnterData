<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" href="./result.css" >
</head>
<body>
<label class="l1">Result for Constituency : </label><label class="l2"><%= (String)request.getAttribute("cons9") %></label>
<% 
int c=(int) request.getAttribute("numberOfCandidates");

for(int i=1;i<=c;i++){

String id=(String)request.getAttribute("cid"+i);
String name=(String)request.getAttribute("cname"+i);
String party=(String)request.getAttribute("cparty"+i);
int count=(int)request.getAttribute("vcount"+i);
%>
<table border="1">
<tr height="150px"><td width="50px"><%= id %></td><td width="200px"><%= name %></td><td width="200px"><%=party %></td>
		<td width="200" class="vc"><%= count %></td>

</table>
<% } %>
<a href="./menu.jsp"><button class="b1">BACK</button></a>
</body>
</html>
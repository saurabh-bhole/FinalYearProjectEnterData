<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Candidates</title>
<link rel="stylesheet" href="./addcandidates.css" >
</head>
<body>
<form action="AddCandidates" method="post" class="can">
	<label>Candidate ID : </label><input type="text" placeholder="Enter ID" name="c_id"><br>
	<label>Candidate Name : </label><input type="text" placeholder="Enter Name" name="c_name"><br>
	<label>Constituency : </label><input type="text" placeholder="Enter Constituency" name="c_cons"><br>
	<label>Party : </label><input type="text" placeholder="Enter Party" name="c_party"><br>
	<label>Choose Symbol : </label><input type="file" name="symbol" placeholder="Choose Symbol"><br>
	<input type="submit" value="ADD">
</form>
<a href="./menu.jsp"><button class="b1">BACK</button></a>

</body>
</html>
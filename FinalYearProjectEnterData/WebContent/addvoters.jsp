<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Voters</title>
<link rel="stylesheet" href="./addvoters.css" >
</head>
<body>
<form action="AddVoters" method="post" class="vote">
	<label>Voter Id : </label><input type="text" placeholder="Enter Voter ID" name="vid" required><br>
	<label>Voter Name : </label><input type="text" placeholder="Enter Name" name="vname" required><br>
	<label>Aadhar UID : </label><input type="text" placeholder="Aadhar UID" name="vaadhar" required><br>
	<label>Mobile : </label><input type="text" placeholder="Mobile Number" name="vmobile" required><br>
	<label>Constituency : </label><input type="text" placeholder="Constituency" name="vcons" required><br>
	<label>Ward : </label><input type="text" placeholder="Ward Number" name="vward" required><br>
	<label>Village : </label><input type="text" placeholder="Village" name="vvillage" required><br>
	<label>City : </label><input type="text" placeholder="City" name="vcity" required><br>
	<label>Taluka : </label><input type="text" placeholder="Taluka" name="vtaluka" required><br>
	<label>Disrict : </label><input type="text" placeholder="District" name="vdistrict" required><br>
	<label>State : </label><input type="text" placeholder="State" name="vstate" required><br>
	<label>Pincode : </label><input type="text" placeholder="Pincode" name="vpin" required><br>
	<input type="submit" value="ADD">
</form>
<a href="./menu.jsp"><button class="b1">BACK</button></a>

</body>
</html>
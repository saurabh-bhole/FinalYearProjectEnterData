<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" href="./register.css" >
</head>
<body>
<form action="./Register" method="post" class="can">
<input type="text" placeholder="Booth ID" name="bid" required><br/>
<input type="text" placeholder="BLO Name" name="bname" required><br/>
<input type="text" placeholder="Create Username" name="buser" required><br/>
<input type="password" placeholder="Password" name="bpass" required><br/>
<input type="password" placeholder="Re-enter Password" name="bpass1" required><br/>
<input type="submit" value="Sign Up"><br/>
</form>
<a href="./menu.jsp"><button class="b1">BACK</button></a>
</body>
</html>
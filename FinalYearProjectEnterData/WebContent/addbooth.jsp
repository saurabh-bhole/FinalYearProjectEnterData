<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booth Information</title>
<link rel="stylesheet" href="./addbooth.css">
</head>
<body>
<form action="AddBooth" method="post" class="can">
<input type="text" placeholder="Booth ID" name="bid" required><br/>
<input type="text" placeholder="Constituency" name="bcons" required><br/>
<input type="text" placeholder="Village" name="bvillage" required><br/>
<input type="text" placeholder="City" name="bcity" required><br/>
<input type="text" placeholder="Taluka" name="btaluka" required><br/>
<input type="text" placeholder="District" name="bdistrict" required><br/>
<input type="text" placeholder="State" name="bstate" required><br/>
<input type="text" placeholder="Pincode" name="bpin" required><br/>
<input type="submit" value="Add Booth"><br/>
</form>
<a href="./menu.jsp"><button class="b1">BACK</button></a>
</body>
</html>
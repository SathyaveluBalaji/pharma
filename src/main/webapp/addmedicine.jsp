<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/addmedicine.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet">
<title>Addmedicine</title>
</head>
<body>
<form action=addmedicine>
<b>
Quantity : <input type=text name="quant"><br><br>
Medicine : <input type=text name="name"><br><br>
Cost : <input type=text name="cost"><br><br>
UniqueId : <input type=text name="unique"><br><br>
</b>
<input type="submit" value=Add-medz><br><br>
<a href='dashboard.jsp'>Back</a>
</form>
</body>
</html>
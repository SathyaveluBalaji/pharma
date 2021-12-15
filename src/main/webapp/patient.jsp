<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient</title>
<link rel="stylesheet" href="styles/patient.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet">
</head>
<body>
<form action=patient>
<b>
<br><br>Patient ID : <input type=text name="patid"><br><br>
Name : <input type=text name="name"><br><br>
Mobile No : <input type=text name="mob"><br><br>
Address : <input type=text name="addr"><br><br>
Date of appointment : <input type=text name="date"><br><br>
</b>
<input type="submit" value=Book><br><br>
<a href='dashboard.jsp'>Back</a>
</form>
</body>
</html>
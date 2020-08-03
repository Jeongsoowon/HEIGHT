<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "Height_DB.Select" %>
<%@ page import = "java.util.Arrays" %>
<html>
<head>
<meta charset="UTF-8">
<title> Select Test </title>
</head>
<body>
	<%
		Select test = new Select();
	
	%>
	<%
		out.print(Arrays.toString(test.Show_allitems()) + "\n");
	
	%>
	
</body>
</html>
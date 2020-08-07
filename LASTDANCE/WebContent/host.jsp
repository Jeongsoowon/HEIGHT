<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content=Type" content="text/html charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/LASTDANCE/connect" method = "get">
		<p> <input type = "text" name = "age" placeholder = "나이"> </p>
		<p> <input type = "text" name = "sex" placeholder = "성별"> </p>
		<p> <input type = "text" name = "height" placeholder = "키"> </p>
		
		 <p><input type="submit" value="제출"></p>
	</form>
	
	<%
		String rankParameter = request.getParameter("rank");
		String percentParameter = request.getParameter("percentile");
		out.println(rankParameter);
		out.println(percentParameter);
		if (rankParameter == null || percentParameter == null){
		
	%>
		<p> No parameter rank given to this page. </p>
	<%
		}
		else
		{
	%>
		<p> The value of parameter rank is <% rankParameter.toString(); %> . </p>
		<p> The value of parameter percentile is <% percentParameter.toString(); %> . </p>
	<%
		}
	%>
</body>
</html>
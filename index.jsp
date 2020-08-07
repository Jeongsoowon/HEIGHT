<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String method = request.getMethod();
 	if ("GET".equals(method)){
 		out.println("can't access");
 	}
 	else {
 		//String inpt = request.getParameter("age");
 		String height = request.getParameter("height");
 		//String male = request.getParameter("male");
 		//String female = request.getParameter("female");
 		out.println("당신, "+ height+ " 라고 썻씁니다.");
 		//out.println("당신, " + height + " '라고 썻씁니다.");
 		//System.out.println(height2);
 	}
 	
%>

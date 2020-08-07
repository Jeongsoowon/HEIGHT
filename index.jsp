<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String method = request.getMethod();
 	if ("post".equals(method)){
 		out.println("can't access");
 	}
 	else {
 		String inpt = request.getParameter("age");
 		//String hs = request.getParameter("height");
 		//String male = request.getParameter("male");
 		String female = request.getParameter("female");
 		//out.println("당신, " + inpt + hs + female +male+" 라고 썻씁니다.");
 		out.println("당신, " +inpt+female +" 라고 썻씁니다.");
 		//out.println("당신, " + height + " '라고 썻씁니다.");
 		//System.out.println(height2);
 	}
 	
%>

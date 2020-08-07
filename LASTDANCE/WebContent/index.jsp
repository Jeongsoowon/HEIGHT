<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="User.UserDAO"
	import="User.UserVO"
	import="Ranking.Rank"


%>

<%
	String method = request.getMethod();
 	if ("post".equals(method)){
 		out.println("can't access");
 	}
 	else {
 		int age = Integer.parseInt(request.getParameter("age"));
 		double height = Double.parseDouble(request.getParameter("height"));
 		boolean sex = Boolean.parseBoolean(request.getParameter("female"));
 		
 		
 		int isMale;
 		if (sex == false) isMale = 1;
 		else isMale = 2;
 		
 		UserVO vo = new UserVO(0, isMale, age, height, 1);
		UserDAO dao = new UserDAO();
		
		double[] result = new double[2];
		result = Rank.Return_Rank(vo, dao);
 		
		
 		out.println("Your Rank is : " + (int)result[0]); %>
 		<br>
<%  	out.println("Your percnetile is :" +  (double)Math.round((result[1]*1000)/1000.000) + "%");
 	
 	}
%> 	


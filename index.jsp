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
 		String Readage = request.getParameter("age");
 		String Readheight = request.getParameter("height");
 		String Readsex = request.getParameter("female");
 		
 		
 		int age = Integer.parseInt(Readage);
 		double height = Double.parseDouble(Readheight);
 		boolean sex = Boolean.parseBoolean(Readsex);
 		//int isMale;
 		//if (sex == false) isMale = 1;
 		//else isMale = 2;
 		
 	//	UserVO vo = new UserVO(0, 2, age, height, 1);
//		UserDAO dao = new UserDAO();
		
//		double[] result = new double[2];
//		result = Rank.Return_Rank(vo, dao);
 		//String male = request.getParameter("male");
 		
 		//out.println("당신, " + inpt + hs + female +male+" 라고 썻씁니다.");
 		out.println("당신, " + age + height + sex +" 라고 썻씁니다.");
 		//out.println("당신, " + height + " '라고 썻씁니다.");
 		//System.out.println(height2);
 	}
 	
%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		Connection conn = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:manage";
		
		try{
			conn = DriverManager.getConnection(jdbcDriver);
			if(conn != null){
				out.print("커넥션 풀에 연결 되었습니다.");
			}else{
				out.print("커넥션 풀에 연결 실패하였습니다.");
			}
		}finally{
			if(conn != null){
				conn.close();//connection 반납
			}
		}
		
	%>
</body>
</html>
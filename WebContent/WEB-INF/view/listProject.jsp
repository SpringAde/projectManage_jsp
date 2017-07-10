<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<style type="text/css">
	table{
		width: 1000px;		
		border: 1px solid gray;
		border-collapse: collapse;
		text-align: center;
		padding-top: 40px;
		margin: 0 auto;
	}
	
	th, tr, td{
		border: 1px solid gray;
		border-collapse: collapse;
	}
	section p{
		text-align: right;
		padding-right: 50px;
	}
	section p a{
		text-decoration: none;
		font-weight: bold;
	}
	
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
	
		<section>
			<p>
				<a href="insert.do">[새 프로젝트 등록]</a>
			</p>
			
			<table>
				<tr>
					<th>프로젝트 이름</th>			
					<th>시작날짜</th>
					<th>종료날짜</th>
					<th>상태</th>
				</tr>
				
				<c:forEach var="item" items="${viewData }">
					<tr>				
						<td><a href="read.do?id=${item.id }">${item.title }</a></td>				
						<td>${item.startDate }</td>				
						<td>${item.endDate }</td>				
						<td>${item.state }</td>
					</tr>		
				</c:forEach>		
			</table>
			</section>
			
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>				
	</div>
</body>
</html>
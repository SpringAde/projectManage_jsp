<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="item" value="${contentView }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<style type="text/css">	
	table{
		width: 1000px;
		margin: 0 auto;
		border: 1px solid gray;
		border-collapse: collapse;
		text-align: center;
		margin-top: 50px;		
	}
	
	th, tr, td{
		border: 1px solid gray;
		border-collapse: collapse;
	}
	
	table th{
		width: 300px;
		text-align: center;
	}
	
	table tr>td{
		padding-left: 20px;
		text-align: left;
	}
	
	section p{
		text-align: center;
		padding-top: 50px;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#delBtn").click(function(e) {
			e.preventDefault(); //링크막기
			
			var id = ${item.id};	//브라우저에서는 서버언어 사용 못함
			var result = confirm("정말 삭제하시겠습니까?");
			if(result == true){
				location.href = "delete.do?id="+id;
			}
		});
	});
</script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
	
		<section>
			<table>		
				<tr>
					<th>프로젝트 이름</th>
					<td>${item.title }</td>
				</tr>		
				<tr>
					<th>프로젝트 내용</th>
					<td>${item.content }</td>
				</tr>		
				<tr>
					<th>프로젝트 시작 날짜</th>
					<td><fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd"/></td>
				</tr>		
				<tr>
					<th>프로젝트 종료 날짜</th>
					<td><fmt:formatDate value="${item.endDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th>프로젝트 상태</th>
					<td>${item.state }</td>
				</tr>
			</table>
	
			<p>
				<a href="modify.do?id=${item.id }">[수정]</a>
				<a href="delete.do" id="delBtn">[삭제]</a>
				<a href="list.do">[목록]</a>
			</p>
		</section>	
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>				
	</div>
	
</body>
</html>
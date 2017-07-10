<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<style type="text/css">
	form{
		width: 800px;
	}
	label{		
		width: 150px;
		float: left;
	}
</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/common.js"></script>
<script>
  $( function() {
    $( ".datepicker" ).datepicker({
    	dateFormat: "yy-mm-dd"    	
    });  
  });
  
  
  $(function(){
		$("form[name='f1']").submit(function(){
			$(".error").css("display","none");			
			
			var endDate = new Date($("#endDate").val());
			var startDate = new Date($("#startDate").val());			
			
			if(endDate.getTime()<=startDate.getTime()){
				$(".dateErr").css("display","block");
				return false;	
			}				
			
			if(checkInputEmpty($("input[name]")) == false || checkInputEmpty($("textarea")) == false){
				checkInputEmpty($("textarea"));
				return false;	
			}
		});
		
		$("#reset").click(function(){
			location.href = "list.do";		
		});
	});

</script>
</head>
<body>	
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
	
		<section>
			<form name="f1" action="modify.do" method="post">
				<fieldset>
					<legend>프로젝트 수정</legend>
					<input type="hidden" name="id" value="${viewData.id }">
					<p>
						<label>프로젝트 이름</label><input type="text" name="title" value="${viewData.title }">
						<span class="error">이름을 입력하세요</span>
					</p>			
					<p>
						<label>프로젝트 내용</label>
						<textarea rows="10" cols="50" name="content" >${viewData.content }</textarea>
						<span class="error">내용을 입력하세요</span>
					</p>
					<p>					   
						<label>시작 날짜</label>
						<input type="text" name="startDate" id="startDate" class="datepicker" 
						value=<fmt:formatDate value="${viewData.startDate}" pattern="yyyy-MM-dd"/>>
						<span class="error">시작 날짜를 선택하세요.</span>								
					</p>
					<p>
						<label>마감 날짜</label>
						<input type="text" name="endDate" id="endDate" class="datepicker" 
						value=<fmt:formatDate value="${viewData.endDate}" pattern="yyyy-MM-dd"/>>
						<span class="error">마감 날짜를 선택하세요.</span>
						<span class="dateErr">마감 날짜가 시작 날짜보다 빠를 수 없습니다.</span>
					</p>
					<p>
						<label>상태</label>												
						
						<select name="state">
				            <option <c:if test="${viewData.state eq '준비' }">selected</c:if>>준비</option>
				            <option <c:if test="${viewData.state eq '진행중' }">selected</c:if>>진행중</option>
				            <option <c:if test="${viewData.state eq '종료' }">selected</c:if>>종료</option>
				            <option <c:if test="${viewData.state eq '보류' }">selected</c:if>>보류</option>				      
		         		</select>
		         		
<%-- 		         		<select name="select">
				            <c:if test="${jspProject.state == '준비'}">
				               <option selected="selected">준비</option>
				               <option>진행중</option>
				               <option>종료</option>
				               <option>보류</option>
				            </c:if>
				            <c:if test="${jspProject.state == '진행중'}">
				               <option>준비</option>
				               <option selected="selected">진행중</option>
				               <option>종료</option>
				               <option>보류</option>
				            </c:if>
				            <c:if test="${jspProject.state == '종료'}">
				               <option>준비</option>
				               <option>진행중</option>
				               <option selected="selected">종료</option>
				               <option>보류</option>
				            </c:if>
				            <c:if test="${jspProject.state == '보류'}">
				               <option>준비</option>
				               <option>진행중</option>
				               <option>종료</option>
				               <option selected="selected">보류</option>
				            </c:if>
       					 </select> --%>
						
					</p>
					
					<p id="submit">
						<input type="submit" value="수정">
						<input type="reset" value="취소" id="reset">
					</p>
				</fieldset>
			</form>			
		</section>	
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>				
	</div>
</body>
</html>
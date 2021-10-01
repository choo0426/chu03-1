<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<style>
<
style type ="text/css">.input_wrap {
	padding: 5px 20px;
}

label {
	display: block;
	margin: 10px 0;
	font-size: 20px;
}

input {
	padding: 5px;
	font-size: 17px;
}

textarea {
	width: 800px;
	height: 200px;
	font-size: 15px;
	padding: 10px;
}

.btn {
	display: inline-block;
	font-size: 22px;
	padding: 6px 12px;
	background-color: #fff;
	border: 1px solid #ddd;
	font-weight: 600;
	width: 140px;
	height: 41px;
	line-height: 39px;
	text-align: center;
	margin-left: 30px;
	cursor: pointer;
}

.btn_wrap {
	padding-left: 80px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<h1>조회 페이지</h1>
	<div class="input_wrap">
		<label>게시판 번호</label> <input name="bno" readonly="readonly"
			value='<c:out value="${pageInfo.bno}"/>'>
	</div>
	<div class="input_wrap">
		<label>게시판 제목</label> <input name="title" readonly="readonly"
			value='<c:out value="${pageInfo.title}"/>'>
	</div>
	<div class="input_wrap">
		<label>게시판 내용</label>
		<textarea rows="3" name="content" readonly="readonly"><c:out
				value="${pageInfo.content}" /></textarea>
	</div>
	<div class="input_wrap">
		<label>게시판 작성자</label> <input name="writer" readonly="readonly"
			value='<c:out value="${pageInfo.writer}"/>'>
	</div>
	<div class="input_wrap">
		<label>게시판 등록일</label> <input name="regdater" readonly="readonly"
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.regdate}"/>'>
	</div>
	<div class="input_wrap">
		<label>게시판 수정일</label> <input name="updateDate" readonly="readonly"
			value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.updateDate}"/>'>
	</div>
	<div class="btn_wrap">
		<a class="btn" id="list_btn">목록 페이지</a> 
		<a class="btn" id="modify_btn">수정하기</a>
	</div>
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"/>'>
	</form>
	<script>
		let form = $("#infoForm");					// infoForm을 form값에 저장

		$("#list_btn").on("click", function(e) {	// id가 list_btn인 버튼을 클릭하면
			form.find("#bno").remove();				// 목록페이지이기 때문에 input의 bno값 삭제
			form.attr("action", "/board/list");		// form태그의 action값을 변경
			form.submit();							// 신호를 컨트롤러로 전송
		});

		$("#modify_btn").on("click", function(e) {	// id가 modify_btn인 버튼을 클릭하면
			form.attr("action", "/board/modify");	// form태그의 action값을 변경
			form.submit();							// 신호를 컨트롤러로 전송
		});
	</script>
</body>
</html>
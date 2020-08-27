<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index페이지</title>
</head>
<body>
	<c:if test="${empty sessionScope.memberID}">
		<button onclick="location.href='loginForm'">로그인</button>
		<button onclick="location.href='joinForm'">회원가입</button>
	</c:if>

	<c:if test="${not empty sessionScope.memberID}">
		<c:if test="${sessionScope.memberID != 'admin' }">
			<h2>${sessionScope.memberID}님환영합니다.</h2>
			<button onclick="location.href='logOut'">로그아웃</button>
			<button onclick="location.href='BoardListButton'">게시판</button>
			<button onclick="location.href='myInfo?loginID=${sessionScope.memberID}'">내정보</button>
		</c:if>
		
		<c:if test="${sessionScope.memberID eq 'admin'}">
			<h2>${sessionScope.memberID}님환영합니다.</h2>
			<button onclick="location.href='logOut'">로그아웃</button>
			<button onclick="location.href='memberList'">회원목록조회</button>
			<button onclick="location.href='BoardListButton'">게시판</button>
		</c:if>
	</c:if>
</body>
</html>

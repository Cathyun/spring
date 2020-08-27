<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>회원목록페이지</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="mbList" items="${mbList}">
		<tr>
				<td>${mbList.mbid}</td>
				<td><a href="memberView?mbid=${mbList.mbid}">${mbList.mbname}</a></td>
				<td><a href="memberModi?mbid=${mbList.mbid}">수정</a></td>
				<td><a href="memberDelete?mbid=${mbList.mbid}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='index'">메인화면으로</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<tr>
			<c:forEach var="mem" items="${mList}">
				<tr>
					<th><a href="memberView?jsid=${mem.jsid}">${mem.jsid}</a></th>
					<th>${mem.jsname}</th>
					<th><a href="memberModify?jsid=${mem.jsid}">수정</a></th>
					<th><a href="memberDelete?jsid=${mem.jsid}">삭제</a></th>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
		</tr>
		<tr>
				<tr>
					<th>${mList.jsid}</th>
					<th>${mList.jspw}</th>
					<th>${mList.jsname}</th>
					<th>${mList.jsbirth}</th>
					<th>${mList.jsgender}</th>
					<th>${mList.jsemail}</th>
				</tr>
		</tr>
	</table>
</body>
</html>
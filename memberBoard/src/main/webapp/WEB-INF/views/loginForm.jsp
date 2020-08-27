<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>
	<form action="login" method="GET">
		<table>
			<tr>
				<td>아이디:<input type="text" name="mbid"></td>
			</tr>
			<tr>
				<td>비밀번호:<input type="password" name="mbpw"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='joinForm'">회원가입하기</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
	<h3>현재아이디</h3>
	아이디:${mbModi.mbid} <br/>
	비밀번호:${mbModi.mbpw} <br/> 
	이름:${mbModi.mbname}<br/>
	생년월일:${mbModi.mbbirth} <br/>
	이메일:${mbModi.mbemail}<br/>
	<br/>
	
	<form action="memberProcess" method="POST">
	<table border="1">
		<tr>
			<td>아이디:
			<input type="hidden" name="mbid">${mbModi.mbid}</td>
		</tr>
		<tr>
			<td>비밀번호:
			<input type="password" name="mbpw"></td>
		</tr>
		<tr>
			<td>생년월일:
			<input type="date" name="mbbirth"></td>
		</tr>
		<tr>
			<td>이메일:
			<input type="email" name="mbemail"></td>
		</tr>
	</table>
	<input type="submit"value="회원수정">
	<input type="reset"value="다시">
	</form>
</body>
</html>
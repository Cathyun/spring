<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>회원수정페이지</h1>
	<table border="1px">
	   <p>현재아이디</p>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td>${mbModify.jsid}</td>
			<td>${mbModify.jspw}</td>
			<td>${mbModify.jsname}</td>
			<td>${mbModify.jsbirth}</td>
			<td>${mbModify.jsgender}</td>
			<td>${mbModify.jsemail}</td>
		</tr>
	</table>
	<br/>
	<form action="modifyProcess" method="POST">
		<table border="1px">
			<tr>
				<td>아이디:${mbModify.jsid}
				<input type="hidden"name="jsid" value="${mbModify.jsid}">
				</td>
			</tr>
			<tr>
				<td>비밀번호:<input type="password" name="jspw"></td>
			</tr>
			<tr>
				<td>이름:<input type="text" name="jsname"></td>
			</tr>
			<tr>
				<td>생년월일:<input type="date" name="jsbirth"></td>
			</tr>
			<tr>
				<td>성별: 여<input type="radio" name="jsgender" value="여">
					           남<input type="radio" name="jsgender" value="남">
				</td>
			</tr>
			<tr>
				<td>이메일:<input type="email" name="jsemail"></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="회원수정"> 
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>
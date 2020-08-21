<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JoinForm(회원가입 페이지)</h2>
	<form action="memberJoin" method="POST">
		<table>
			<tr>
				<td>아이디:<input type="text" name="jsid"></td>
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
		<input type="submit" value="회원가입">
		<input type="reset" value="다시 작성">
	</form>
</body>
</html>
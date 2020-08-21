<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="GET">
	  <table>
	  <tr>
	  	<td>아이디:<input type="text"name="id"></td>
	  </tr>
	  <tr>	
	  	<td>비밀번호:<input type="password"name="pw"></td>
	  </tr>
	  <tr>
	   <td>성별<input type="radio"name="gender" value="여자">여자<input type="radio"name="gender" value="남자">남자</td>
	  </tr>
	  <tr>
	   <td>생년월일:<input type="date"name="jdate"></td>
	  </tr>
	  </table>
	  <input type="submit" value="회원가입">
	</form>
</body>
</html>
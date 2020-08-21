<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LoginForm(로그인페이지)</h1>
	<form action="memberLogin" method="post" id="loginForm">
		<input type="text" name="jsid" placeholder="아이디">
		<input type="password" name="jspw" placeholder="비밀번호">
	</form>
	<button onclick="login()">로그인</button>
	<button onclick="joinForm()">회원가입</button>
</body>
<script>
	function login(){
     	loginForm.submit();
	}
	function joinForm(){
    	 location.href="joinForm"
	}

</script>
</html>
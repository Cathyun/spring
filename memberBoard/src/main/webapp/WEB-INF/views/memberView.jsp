<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${myInfo.mbid}</td>
			<td>${myInfo.mbpw}</td>
			<td>${myInfo.mbname}</td>
			<td>${myInfo.mbbirth}</td>
			<td>${myInfo.mbemail}</td>
		</tr>
	</table>
	<button onclick="location.href='memberList'" >목록으로</button>
</body>
</html>
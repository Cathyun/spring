<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원수정페이지</h1>
	<table border="1">
		<p>현재아이디</p>
		<tr>
			<td>글 번호</td>
			<td>작성자</td>
			<td>비밀번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>등록일</td>
			<td>첨부파일</td>
			<td>조회수</td>
		</tr>
		<tr>
			<td>${bModify.bnum }</td>
			<td>${bModify.bwriter }</td>
			<td>${bModify.bpassword }</td>
			<td>${bModify.btitle}</td>
			<td>${bModify.bcontents}</td>
			<td>${bModify.bdate }</td>
			<td>${bModify.bfilename }</td>
			<td>${bModify.bhit }</td>
		</tr>
	</table>
	<br />
	<form action="listProcess" method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>글번호</td>
				<td><input type="hidden" name="bnum" value="${bModify.bnum}">${bModify.bnum}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bwriter"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="bpassword"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="40"name="bcontents"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="bfile">
				<input type="hidden"name="page"value="${page}"></td>
			</tr>
		</table>
		<br/> 
		<input type="submit" value="수정"> 
		<input type="reset" value="다시 작성">
	</form>

</body>
</html>
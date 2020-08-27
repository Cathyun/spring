<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listModify</title>
</head>
<body>
	<table border="1">
	
		<tr>
			<td>글번호:${boList.bnum}<br /></td>
		</tr>
		<tr>
			<td>작성자:${boList.bwriter}<br /></td>
		</tr>
		<tr>
			<td>비밀번호:${boList.bpassword}<br /></td>
		</tr>
		<tr>
			<td>제목:${boList.btitle}<br /></td>
		<tr>
		<tr>
			<td>내용:${boList.bcontents}<br /></td>
		</tr>
		<tr>
			<td>작성일자:${boList.bdate}<br /></td>
		</tr>
		<tr>
			<td>조회수:${boList.bhit}<br /></td>
		</tr>
		<tr>
			<td><img src="resources/fileUpload/${boList.bfilename}" width="300px"><br /></td>
		</tr>
	</table>
	<form action="listProcess" method="POST" name="ModiForm" enctype="multipart/form-data" >
		<table>
			<tr>
				<td>글번호</td>
				<td><input type="hidden" name="bnum" value="${boList.bnum}">${boList.bnum}</td>
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
				<td><textarea rows="20" cols="40" name="bcontents"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name ="bfile"></td>
			</tr>
		</table>
	</form>
	<button onclick="listModify()">글수정</button>
	<button onclick="location.href='pagingList'">글목록</button>
</body>
<script>
	function listModify() {
		ModiForm.submit();
	}
</script>



</html>
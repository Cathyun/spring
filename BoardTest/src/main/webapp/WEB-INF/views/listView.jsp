<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listView</title>
</head>
<body>
<table border ="1">
		<tr>
			<td>글 번호</td>
			<td>작성자</td>
			<td>비밀번호</td>
			<td>제목</td>
			<td>등록일</td>
			<td>첨부파일</td>
			<td>조회수</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<tr>		
			<td>${lList.bnum }</td>
			<td>${lList.bwriter }</td>
			<td>${lList.bpassword }</td>
			<td>${lList.btitle}</td>
			<td>${lList.bdate }</td>
			<td><img src="resources/fileUpload/${lList.bfilename}" width="300px">${lList.bfilename}</td>
			<td>${lList.bhit }</td>		
			<td><a href="listModify?bnum=${lList.bnum}&page=${paging.page}">수정</a></td>
			<td><a href="boardDelete?bnum=${lList.bnum}&page=${paging.page}">삭제</a></td>
		</tr>
	</table>
	<button onclick ="location.href='pagingList?page=${page}'">목록으로</button>
</body>
</html>
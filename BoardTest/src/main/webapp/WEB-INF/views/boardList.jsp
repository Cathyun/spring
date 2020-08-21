<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		</tr>
		<c:forEach var="boardList" items="${boardList}">
		<tr>		
			<td>${boardList.bnum }</td>
			<td>${boardList.bwriter }</td>
			<td>${boardList.bpassword }</td>
			<td>${boardList.btitle }</td>
			<td>${boardList.bdate }</td>
			<td>${boardList.bfile }</td>
			<td>${boardList.bhit }</td>		
		</tr>
		</c:forEach>	
	</table>
	<!--페이징 처리  : 이전의 맨마지막 이 1이다-->
	<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>
	<!-- 페이지를 하나 전으로 이동하겠다. -->
	<c:if test="${paging.page>1}">
       
		<a href="pagingList?page = ${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
		step="1">

		<c:choose>
			<c:when test="${i eq paging.page }">
	        ${i}
	     </c:when>
			<c:otherwise>
				<a href="pagingList?page=${i}">${i}</</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>= paging.maxPage}"></c:if>
	<c:if test="${paging.page<paging.maxPage}">

		<a href="pagingList?page = ${paging.page+1}">[다음]</a>&nbsp;</c:if>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="search">
		<select name="searchCondition">
				<option selected disable hidden>검색조건</option>
				<option value="1">작성자</option>
				<option value="2">글제목</option>
		</select> 
		<input type="text" placeholder="내용" name="keyword" />
		<input type="submit" value="검색"/>
	</form>
	
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="list" items="${pagingList}">
			<tr>
				<td>${list.bnum}</td>
				<td>${list.bwriter }</td>
				<td><a href="listView?bnum=${list.bnum}">${list.btitle}</a></td>
				<td>${list.bhit}</td>
			</tr>
		</c:forEach>
	</table>

	<!--페이징 처리-->
	<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>
	<!-- 페이지를 하나 전으로 이동하겠다. -->
	<c:if test="${paging.page>1}">
		<a href="pagingList?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.startpage}" end="${paging.endpage}" var="i"
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
	<c:if test="${paging.page>= paging.maxpage}">[다음]</c:if>
	<c:if test="${paging.page<paging.maxpage}">
		<a href="pagingList?page=${paging.page+1}">[다음]</a>&nbsp;</c:if>
</body>
</html>
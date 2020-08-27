<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pagingList</title>
</head>
<body>
	<!--검색기능  -->
	<form action="search">
		<select name="searchCondition">
			<option value="1">작성자</option>
			<option value="2">제목</option>
		</select> <input type="text" placeholder="내용" name="content" /> <input
			type="submit" value="검색">
	</form>

	<!-- 게시물목록  -->
	<table border="1">
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="boardList" items="${pagingList}">
			<tr>
				<td>${boardList.bwriter}</td>
				<td><a href="listView?bnum=${boardList.bnum}">${boardList.btitle}</a></td>
				<td>${boardList.bhit}</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='BoardListButton'">뒤로가기</button>
	<br />
	
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






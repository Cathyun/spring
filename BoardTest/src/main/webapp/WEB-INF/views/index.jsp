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

<!--이미지추가  -->
<%-- <img src="<spring:url value='/resources/fileUpolod/${pagingList.bfile}'/>"> --%>
<button onclick="location.href='boardForm'">글쓰기</button>
<button onclick="location.href='pagingList'">목록보기</button>
</body>
</html>
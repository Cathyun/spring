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
	<table>
	<tr>
	 <th>이름</th>
	 <th>주소</th>
	 <th>나이</th>
	</tr>
	<tr>
	 <c:forEach var = "mem" items="${mList}">
	  <tr>
	    <th>${mem.mname}</th>
	    <th>${mem.maddr}</th>
	    <th>${mem.mage}</th>
	  </tr>
     </c:forEach>
	</tr>
	</table>
</body>
</html>
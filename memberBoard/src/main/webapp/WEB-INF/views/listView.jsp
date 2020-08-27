<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listView</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">

	//페이지 로딩시 댓글목록조회	
	$(document).ready(function() {
		var cbnum =${boList.bnum};
		$.ajax({
			type : "POST",
			url : "comment/commentlist",
			data : { "cbnum" : cbnum },
			dataType : "json",
			success : function(result) {
				commentList(result);
			},
			error : function() {
				alert("댓글 조회 실패");
			}	
	});
});

	//댓글목록
	function commentList(result) {
		var output = " ";
		output += "<table><tr>";
		output += "<th>작성자</th>";
		output += "<th>내용</th>";
		output += "<th>삭제</th></tr>";

		for ( var i in result) {
			output += "<tr>";
			output += "<td>" + result[i].cwriter + "</td>";
			output += "<td>" + result[i].ccontents + "</td>";
			output += "<td><button onclick='commentDelete(" + result[i].cnum
					+ ")'>삭제</button></td>";
			output += "</tr>";
		}

		output += "</table>";
		$("#commentArea").html(output);
	}

	
	//댓글입력
	$(document).ready(function() {
		$("#commentWriteBtn").click(function() {

			var cwriter = $("#cwriter").val();
			var ccontents = $("#ccontents").val();
			var cbnum = ${boList.bnum};

			$.ajax({
				type : "POST",
				url : "comment/commentwrite",
				data : {
					"cwriter" : cwriter,
					"ccontents" : ccontents,
					"cbnum" : cbnum
				},
				dataType : "json",
				success : function(result) {
					commentList(result);
					$("#cwriter").val("");
					$("#ccontents").val("");
				},
				error : function() {
					alert("댓글 입력 실패");
				}
			});
		});
	});

 	//댓글삭제
 	function commentDelete(cnum){
 	 	$.ajax({
 	 		type : "GET",
			url : "comment/commentdelete",
			data : {
				"cnum":cnum,
				"cbnum" : ${boList.bnum}
			},
			dataType : "json",
			success : function(result) {
				commentList(result);
			},
			error : function() {
				alert("댓글 삭제 실패");
			}
 	});
}
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>조회수</th>
			<th>첨부파일</th>
			<th>작성일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<tr>
				<td>${boList.bwriter}</td>
				<td>${boList.btitle}</td>
				<td>${boList.bcontents}</td>
				<td>${boList.bhit}</td>
				<td><img src="resources/fileUpload/${boList.bfilename}"
				width="200px">${boList.bfilename}</td>
				<td>${boList.bdate}</td>
				<td><a href="listModify?bnum=${boList.bnum}">수정</a></td>
				<td><a href="listDelete?bnum=${boList.bnum}">삭제</a></td>
			</tr>
	</table>
	<br />

	<div>
		<table>
			<tr>
				<td>작성자:<input type="text" id="cwriter"><br /></td>
			</tr>
			<tr>
				<td>댓글:<textarea rows="5" cols="20" id="ccontents"></textarea><br /></td>
			</tr>
		</table>
		<button id="commentWriteBtn">댓글입력</button>
	</div>

	<div id="commentArea"></div>
	
	
	<button onclick="location.href='pagingList'">목록으로</button>
	
</body>
</html>
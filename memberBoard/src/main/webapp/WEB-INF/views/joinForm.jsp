<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.js"></script>
<script>
	function idOverlap(){
		//input치는 id값	
	var idCheck=document.getElementById("idForm").value;

	//주소값 나타내는 var
	var confirmId=document.getElementById("confirmId");
	
	$.ajax({
		type:"POST",
		url:"idoverlap",
		data:{"mbid" : idCheck},
		dataType:"text",
		success:function(data){//성공시
			console.log("data값"+data);
		if(data=="OK"){
			confirmId.style.color="#0000ff";
			confirmId.innerHTML="사용가능한 아이디";
		}else{
			confirmId.style.color="#ff0000";
			confirmId.innerHTML="사용중인 아이디";
		}
	},
	error:function(){//실패시
		alert("idOverlap 함수 통신 실패!!");
	}
  });//end ajax
}//end id Overlap()
</script>

</head>
<body>
  <h3>회원가입페이지</h3>
  <form action="join" method="POST">
  	<table>
  		<tr>
  			<td>아이디:<input type="text" id="idForm" name="mbid" onkeyup="idOverlap()">
				<span id="confirmId"></span>
  		<tr>
  		<tr>
  			<td>비밀번호:<input type="password"name="mbpw"></td>
  		<tr>
  		<tr>
  			<td>이름:<input type="text"name="mbname"></td>
  		<tr>
  		<tr>
  			<td>생년월일:<input type="date"name="mbbirth"></td>
  		<tr>
  		<tr>
  			<td>이메일:<input type="email"name="mbemail"></td>
  		<tr>
  	</table>
  	<input type="submit" value="회원가입">
  	<input type="reset" value="다시작성">
  </form>
  
</body>
</html>
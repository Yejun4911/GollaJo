<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
    src: url("fonts/08SeoulNamsanM_0.ttf"); 
  	font-family: 'SeoulNamsan';
}


*{
	box-sizing: border-box;
	font-family: 'SeoulNamsan';
}


h1{
	font-size: 40px;
}	

.content{
	width:400px;
	height:400px;
	line-height:500px;
	margin:0 auto;
	padding: auto auto;
	text-align:center;
}

.choice{
	margin-top:100px;
	line-height:normal;
	padding:auto auto;
}
input[type=button]{
	width:300px;
	height:300px;
	border-radius: 200px;
	border : none;	
	font-size : 25px;
	margin:30px;
	color:white;
	
}

#random{
	background-color:rgb(231, 76, 60);
}
#reset{
	width:150px;
	height:50px;
	border-radius: 5px;
	border : none;	
	font-size : 25px;
	margin:30px;
	color:white;
	background-color:black;
}
#reset2{
	width:150px;
	height:50px;
	border-radius: 5px;
	border : none;	
	font-size : 25px;
	margin:30px;
	color:white;
	background-color:black;
}

</style>

</head>
<body>
<%@ include file="../view/header.jsp" %>

<form action="choice2.jsp">
	<div class = "content">
		<div class="choice">
			<h1>완전 랜덤 !</h1>
			<input type ="button" name="random" value="${name}" id="random">
			<input type ="button" name="reset" value="재선택" id="reset" onClick="window.location.reload()">
			<input type ="button" name="reset" value="선택" id="reset2" onclick="location.href='${pageContext.request.contextPath}/food/random_real_result.jsp?confirm=${name}'">
		</div>
	</div>
</form>	
<%@ include file="../view/footer.jsp" %>
</body>
</html>
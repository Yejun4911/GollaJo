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
	vertical-align:middle;
}

.choice{
	margin-top:100px;
	display:inline-block;
	line-height:normal;
	vertical-align:middle;
	padding:auto auto;
}
input[type=button]{
	width:300px;
	height:100px;
	border-radius: 5px;
	border : none;	
	font-size : 25px;
	cursor: pointer;
	margin:30px;
	color:white;
}

#taste{
	 background-color: red;
}

#situation{
	 background-color: rgb(46, 204, 113);
	 
}
#random{
	backgroun-color:blue;
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

</style>

</head>
<body>
<%@ include file="view/header.jsp" %>

<form action="choice2.jsp">
	<div class = "content">
		<div class="choice">
			<h1>완전 랜덤 !</h1>
			<input type ="button" name="random" value="${name}" id="taste">
			<input type ="button" name="reset" value="재선택" id="reset" onClick="window.location.reload()">
		</div>
	</div>
</form>	
<%@ include file="view/footer.jsp" %>
</body>
</html>
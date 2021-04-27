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

.container{
	
	
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
}

#taste{
	 background-color: red;
	 margin-bottom: 20px;
	 margin-top: 35px;
}

#situation{
	 background-color: rgb(46, 204, 113);
	 margin-top:20px;


.class{
	padding: auto auto;
}

</style>
</head>
<body>
	
	<div class = "container">
		<div class="choice">
			<h1>당신의 취향은?</h1>
			<input type ="button" name="taste" value="맵다" id="taste" onclick="location.href='tasteChoice2.jsp?taste1=맵다'">
			<input type ="button" name="situation" value="안 맵다" id="situation" onclick="location.href='tasteChoice2.jsp?taste1=안맵다'">
		</div>
	</div>
	
</body>
</html>
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
	margin:auto auto;
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

#taste1{
	 background-color: red;
	 margin-bottom: 20px;
	 margin-top: 35px;
}

#taste2{
	 background-color: rgb(46, 204, 113);
	 margin-bottom: 20px;
	 margin-top:20px;
}

#taste3{
	 background-color: rgb(241, 196, 15);
	 margin-top:20px;
}

.class{
	padding: auto auto;
}

</style>
</head>
<body>
<div class = "container">
	<div class="choice">
	
		<h1>취향을 골라조!</h1>
		<input type ="button" name="taste1" value="선택지1" id="taste1" onclick="">
		<input type ="button" name="taste2" value="선택지2" id="taste2" onclick="">
		<input type ="button" name="taste3" value="선택지3" id="taste3" onclick="">
	</div>
</div>
</body>
</html>
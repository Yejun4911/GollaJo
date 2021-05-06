<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>골라조</title>
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

#situation{
	 background-color: rgb(46, 204, 113);
	 
}
#random{
	backgroun-color:blue;
}
#reset1{
	width:150px;
	height:50px;
	border-radius: 5px;
	border : none;	
	font-size : 25px;
	margin:30px;
	color:white;
	background-color:black;
}
#realresult{
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
<script>
var arr = new Array();
<c:forEach items="${list}" var="item">
	arr.push("${item}");
</c:forEach>

function reresult() {
	arr.shift();
	if(arr.length!=0){
		document.getElementById("situation").value=arr[0];
		//document.getElementById("reset1").setAttribute("onClick", url());
	
	}else{
		document.getElementById("situation").value="메뉴가 더 이상 없습니다.";
		document.getElementById("reset1").value="처음으로";
		document.getElementById("reset1").setAttribute("onClick", "location.href='${pageContext.request.contextPath}/food/food_case.jsp?choice=2'");
	}
}
function url(){
	location.href="${pageContext.request.contextPath}/food/sit_real_result.jsp?confirm="+arr[0];
}
</script>
</head>

<body>
<%@ include file="../view/header.jsp" %>

<form action="choice2.jsp">
	<div class = "content">
		<div class="choice">
			<h1>상황 !</h1>
			<input type ="button" name="random" value="${list[0]}" id="situation"></input>
			<input type ="button" name="reset" value="재선택" id="reset1" onclick="reresult();">
			<input type ="button" name="confirm" value="선택" id="realresult" onclick="url();">
			
		</div>
	</div>
</form>	
<%@ include file="../view/footer.jsp" %>
</body>
</html>
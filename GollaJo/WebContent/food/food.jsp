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


	body{

	 	background-size:cover;
	 	box-sizing: border-box;
		font-family: 'SeoulNamsan';

	  }
  
	.wrapper{
	  margin:270px auto;
	  display:block;
	  width:100%; 
	  max-width:270px;
	  position:relative;
	  background:none;
	}
	
	.taste{
	   height:36px;
	  margin-left:50px;
	  font-size:18px;
	  text-align:center;
	  color:black;
	  position:relative;
	  top: -50px;
	  z-index:3;
	  cursor:pointer;
	  padding:10px;

	}
	.situation{
	  height:36px;
	  margin-left:50px;
	  font-size:18px;
	  text-align:center;
	  color:black; 
	  z-index:4;
	  cursor:pointer;
	  position:relative;
	  top: -25px;
	  padding:10px;
	}

	.random{

	height:36px;
	  margin-left:50px;
	  font-size:18px;
	  text-align:center;
	  color:black;
	  z-index:4;
	  cursor:pointer;
	  position:relative;

	  padding:10px;
	}


	.hovers{
	  position:absolute;
	  top:-45px;
	  width:80%;
	  height:36px;
	  background-color:#dedeff;
	  border-radius:40px;
	  border:2px solid #dedeff;
	  z-index:1;
	  margin-left:55px;
	  transition:0.5s;
	}

	.taste:hover ~ .hovers{
	  background-color:#8282ff;
	  border:2px solid #8282ff;
	  transform:translateY(0%);
	  
	}
	.situation:hover ~ .hovers{
	  background-color:#d25a5a;
	  border:2px solid #d25a5a;
	   transform:translateY(230%);
	}
	.random:hover ~ .hovers{
	  background-color:#7ba87b;
	  border:2px solid #7ba87b;
	   transform:translateY(450%);
	}

	h1{
		font-size: 40px;
	}	

	#hea{
		text-align:center;
	}

</style>
</head>

<body>
<%@ include file="../view/header.jsp" %>
<h1 id ="hea">오늘은 어때?</h1>
<div class="wrapper">
	
  	<div class="taste" id="taste" onclick="location.href='food_taste1.jsp?choice=1'">취향으로</div><br>
  	<div class="situation" id="situation" onclick="location.href='food_case.jsp?choice=2'">상황으로</div><br>
  	<div class="random" id="random" onclick="location.href='${pageContext.request.contextPath}/food.do?choice=3'">아무거나</div>
  
 	 <div class="hovers"></div>
</div>
	<%@ include file="../view/footer.jsp" %>
</body>
</html>
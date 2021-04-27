<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@font-face {
   src: url("fonts/08SeoulNamsanL_0.ttf"); 
  	font-family: "SeoulNamsanL";
	}
	
	* {
		margin:0;
		padding:0;
		font-family: "SeoulNamsanL";
		box-sizing: border-box;
	}
	
	ul {
		list-style: none;
		
	}
	
	a {
		text-decoration: none;
		outline: none;
	}
	
	header {
		width:100%;
		height:80px;
		display: flex;
		align-items: center;
		justify-content: space-between;
	}
	.container{
		margin:0 auto;
		background-color:rgb(231, 76, 60);
	}
	header > h2 {
		margin-left:20px;
	}
	
	header > nav {
		width:200px;
		height:100%;
	}
	
	header ul {
		width:100%;
		height: 100%;
		display: flex;
		font-weight: 900;
	}
	
	header ul > li {
		font-size:20px;
		height: 100%;
		display: flex;
		align-items: center;
		padding-left:20px;
	}
	header ul > li > a{
		font-family: 'Recipekorea';
		color:white;
	}
	#logo{
		widht:100px;
		height:100px;
		display: flex;
		align-items: center;
	}
	
</style>	
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div class="container">
		<header>
			<a href="index.jsp"><img src="image/logo.png" id="logo"></a>
			<nav>
				<ul>
				<c:choose>
					<c:when test="${!empty vo}">
						<li style="padding-left:100px;"><a href="logout.jsp">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="signIn.jsp">로그인</a></li>
						<li><a href="signUp.jsp">회원가입</a></li>
					</c:otherwise>	
				</c:choose>
				</ul>			
			</nav>
		</header>
	</div>
</body>
</html>
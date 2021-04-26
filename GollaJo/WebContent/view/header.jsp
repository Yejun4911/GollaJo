<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@font-face {
    font-family: 'Recipekorea';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	* {
		margin:0;
		padding:0;
		font-family: 'Recipekorea';
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
	}
	
	header ul > li {
		font-size:20px;
		height: 100%;
		display: flex;
		align-items: center;
		padding-left:10px;
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
					<li><a href="signIn.jsp">로그인</a></li>
					<li><a href="signUp.jsp">회원가입</a></li>
				</ul>			
			</nav>
		</header>
	</div>
</body>
</html>
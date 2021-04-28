<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>골라조</title>
	<style type="text/css"> 
		.wrapper {
	
		display: grid;
		grid-template-columns: 200px 200px 200px 200px;
		grid-template-rows:600px;
		align-items: center;
		justify-content: center;
		grid-gap: 100px;
	}
	.wrapper > div {
		margin-top:200px;
		padding:100px 50px 100px 50px ;
		background-color:rgb(231, 76, 60);
		border-radius:30px;
	}
	.wrapper > div > a{
		text-align:center;
		margin-left:auto; 
		margin-right:auto;
		color:white;
	}
	
	</style>
</head>
<body>
	<%@ include file="view/header.jsp" %>
	<div class="wrapper">
    		<div><a href="food.jsp"><h2>음식메뉴 골라조</h2></a></div>
	    	<div><a href="#"><h2>중간지점 골라조</h2></a></div>
			<div><a href="#"><h2>골라조<br>버튼</h2></a></div>
			<div><a href="boardList.do?page=1"><h2>골라조<br>게시판</h2></a></div>
	</div>
	<%@ include file="view/footer.jsp" %>
	
</body>
</html>
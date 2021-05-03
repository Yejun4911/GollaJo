<%@page import="com.gollajo.model.BoardsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

#write{
	width: 30px;
	float: right;	
	margin-bottom: 10px;
	margin-right: 30px;
}

h1 {
	font-size: 50px;
	padding : 70px;
	margin : 0 auto;
}

	
.container-board{
	padding: 30px;
	margin: 0 auto; 
	}


.container-board table {
  width: 100%;
  border-collapse: collapse;

  }
  
.container-board table tr{
	height: 40px;
	text-align: center;
}

.container-board table th{
	border-top : 2px solid #D8D8D8;
	border-bottom: 2px solid #D8D8D8;
	background-color: #E6E6E6;
}

.container-board table td {
	border-bottom: 2px solid #D8D8D8;
	background-color: #FFFFFF;
}


.paging {
	text-align: center;
	font-size: 20px;
	margin-top: 30px;
}

.search-box {
	height: 50px;
	width: 250px;
	border: 1px solid #dadbd6;
	background: #ffffff;
	float: right;
}

.search-box button {
	width: 40px;
	height: 40px;
	border: 0px;
	outline: none;
	float: left;
	padding: 5px
}

.search-box button img {
	width: 35px;
	height: 35px;
	
}

.search-box input {
	font-size: 20px;
	width: 180px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: right;
	
}

</style>
</head>
<body>
<%@ include file="../view/header.jsp" %>
<form action="boardList.do">
<h1 align="center">골라조 게시판</h1>

	<c:choose>
		<c:when test="${!empty vo}">
			<a href="${pageContext.request.contextPath}/board/board_write.jsp"><img id="write" src="image/write.png"></a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/login/signIn.jsp"><img id="write" src="image/write.png"></a>
		</c:otherwise>
	</c:choose>
	
	<div class="container-board">
		<table>
        	<thead>
        		<tr>
         		   <th align="center" width="5%"><b>번호</b></th>
         		   <th align="center" width="50%"><b>제목</b></th>
        		   <th align="center" width="15%"><b>작성자</b></th>
        		   <th align="center" width="15%"><b>날짜</b></th>
            	   <th align="center" width="15%"><b>조회수</b></th>
        	   </tr>
       		</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.boardIdx}</td>
						<td><a href="boardDetail.do?board_idx=${board.boardIdx}"><font color="black"><b>${board.title}</b></font></a></td>
						<td>${board.nickname}</td>
						<td>${board.registerDatetime}</td>
						<td>${board.viewCount}</td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>
		<div class="paging">
			<c:if test="${1 < page}">
				<span><a href="boardList.do?page=${page-1}">&lt;</a></span>
			</c:if>
			<c:choose>
       			<c:when test="${page - (page - 1) % 5 + 4 > pageCount}">
            	<c:set var="end" value="${pageCount}"/>
        		</c:when>
        		<c:otherwise>
            	<c:set var="end" value="${page - (page - 1) % 5 + 4}"/>
        		</c:otherwise>
    		</c:choose>
			<c:forEach var= "i" begin="${page - (page - 1) % 5}" end="${end}">
			
			
			<c:if test="${ i eq page}"><b>${i}</b></c:if>
			<c:if test="${i ne page}"><a href="boardList.do?page=${i}">${i}</a></c:if>
			
			 
			</c:forEach>
			<c:if test="${pageCount > page}">
				<span><a href="boardList.do?page=${page+1}">&gt;</a></span>
			</c:if>

		</div> 
	</div>
</form>	
</body>
</html>
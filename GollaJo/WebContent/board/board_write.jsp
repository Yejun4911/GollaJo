<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0">
<!DOCTYPE html>
<title>골라조 게시판</title>

<style type="text/css">
@font-face {
    src: url("fonts/08SeoulNamsanM_0.ttf"); 
  	font-family: 'SeoulNamsan';
}


	input[type=text]{
		outline:none;
		margin:0 auto;
		padding: 1% 1% 1% 1%; 

	}	
	textarea[name=answer1]{
		border: 5px solid rgb(231, 76, 60);
		margin-right: 5%;
	}	
	textarea[name=answer2]{
		border: 5px solid rgb(46, 204, 113);
		margin-left: 5%;
	}
	
	textarea[name=answer1], [name=answer2]{
		height:30%;
		width:28%;
		border-radius: 5px; 
		font-size : 15px;
		font-color : gray;
		font-weight : bold;
		display:inline-block;
		cursor: pointer;
		text-align:center;
   	 	vertical-align:middle;
		margin-top:0.5%;
		margin-bottom: ;
		
		resize: none;
	}	
	
	#contentchoice1{
		padding: 4% 2%;
	}
	#contentchoice2{
		padding: 4% 2%;
	}
	

	textarea#contenttext{
		border: 2px medium black;
		outline:none;
		margin: 5% 1% 1% 1%;
		width: 99%;
		height: 93%;
		padding: 1% 1% 1% 1%;
	}

	span{
		font-size: 30px;
      	text-style: bold;
	}
	
	
    body {
        margin: 0px;
     }

     .all{
      	top:35%;
      	margin: 0 auto;
        padding: 10px;
        border-radius: 5px;   
        top:50%;
		left:50%; 
		overflow:auto;
      }
      
     .cb {     	
     	border: 2px medium black;
        box-sizing: content-box;
        width:75%;
        margin: 1% 1% 1% 13%;  

      }

      
      .content{
       	border: 2px black;
      	box-sizing: content-box;
      	height: 20%;
      	margin: 1% 1% 1% 13.5%;
      	width: 70%;
      }
   
      .choice{
      	margin: 1% 6% 1% 5%;
      	vertical-align: middle;
      }
      
      .button{
      	border: none;
      	margin: 4% 1% 0.005% 78% ;
      	margin-bottom: 80px;


      }
      
      .uploadbtn{
      	  font-size: 18px;
      	  padding: 2% 3%;
      	  border: 2px solid grey;
      	  color: grey;
      	  background-color: #dcdcdc;
      	  border-radius: 5px;

      }


	div#wrapper {
		position: absolute;
		top:50%;
		left:50%;
		}	
		
.myButton {
	box-shadow:inset 0px 1px 0px 0px #f5978e;
	background:linear-gradient(to bottom, #f24537 5%, #c62d1f 100%);
	background-color:#f24537;
	border-radius:6px;
	border:1px solid #d02718;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:13px;
	font-weight:bold;
	padding:7px 13px;
	text-decoration:none;
	text-shadow:0px 1px 0px #810e05;
}
.myButton:hover {
	background:linear-gradient(to bottom, #c62d1f 5%, #f24537 100%);
	background-color:#c62d1f;
}
.myButton:active {
	position:relative;
	top:1px;
}

</style>
<body>
<%@ include file="../view/header.jsp" %>
<c:choose>
<c:when test="${!empty board}">
<form action='${pageContext.request.contextPath}/boardUpdate.do' method="post">
	<input type="hidden" name="user_idx" value="${vo.userIdx}">
	<input type="hidden" name="board_idx" value="${board.boardIdx}">
	<div class="all">
    	<div class="cb">
      		<input type="text" value="${board.title}" placeholder="제목을 입력하세요" name="title" maxlength="50" style="width:95%;" required>
   		</div>
            <div class ="choice" style="text-align:center;border:0;">
               <textarea id="contentchoice1" placeholder="선 택 1&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer1" maxlength="10" ; required>${board.answer1}</textarea>
          			<span><strong>VS</strong></span>
               <textarea id="contentchoice2" placeholder="선 택 2&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer2" maxlength="10"; required>${board.answer2}</textarea>
    	</div>
    	
    	<div class ="content">
      		<textarea id="contenttext" wrap="virtual" placeholder="글을 입력하세요"  name="question" maxlength="2040" >${board.question}</textarea>
		</div>

    	<div class="button">
    		<button type="submit" class="uploadbtn btn-primary pull-right myButton" value="upload" style="cursor:pointer">올리기</button>	
    	</div>
	</div>
</form>
</c:when>
<c:otherwise>
<form action='${pageContext.request.contextPath}/boardRegister.do' method="post">
	<input type="hidden" name="user_idx" value="${vo.userIdx}">
	<div class="all">
    	<div class="cb">
      		<input type="text" placeholder="제목을 입력하세요" name="title" maxlength="50" style="width:95%;" required>
   		</div>
            <div class ="choice" style="text-align:center;border:0;">
               <textarea id="contentchoice1" placeholder="선 택 1&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer1" maxlength="10" ; required></textarea>
          			<span><strong>VS</strong></span>
               <textarea id="contentchoice2" placeholder="선 택 2&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer2" maxlength="10"; required></textarea>
    	</div>
    	
    	<div class ="content">
      		<textarea id="contenttext" wrap="virtual" placeholder="글을 입력하세요"  name="question" maxlength="2040" ></textarea>
		</div>

    	<div class="button">
    		<button type="submit" class="uploadbtn btn-primary pull-right myButton" value="upload" style="cursor:pointer">올리기</button>	
    	</div>
	</div>
</form>
</c:otherwise>
</c:choose>

<%@ include file="../view/footer.jsp" %>

</body>
</html>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
#table_header td{
	height: 30px;
	vertical-align: bottom;
}
#question{
	border: none;	
	outline:none;
	margin:0 auto;
	}	
input[name=answer1]{
	background-color: rgb(231, 76, 60);
	}	
input[name=answer2]{
	background-color: rgb(46, 204, 113);
	}
	
input[name=answer1], [name=answer2]{
	height:70px;
	border-radius: 5px;
	border : none;	
	font-size : 25px;
	display:inline-block;
	cursor: pointer;
	text-align:center;
    vertical-align:middle;
    margin-bottom: 35px;
	margin-top: 35px;
	margin-left: 20px;
}	

input[type=textarea]{
	height: 70%;
}
body {
	margin: 0px;
}
div {
	margin: 0 auto;
	padding: 10px;
	top:50%;
	left:70%;
	width:70%
}
.h {
	box-sizing: content-box;
}
div > h6 { 
	text-align: right;
}
.bb {
	box-sizing: content-box;
	height: 490px;
	margin:0 auto;
	border: 2px solid #dddddd;
	border-radius: 5px;   
}
    	
div> bb > c1{
	box-sizing: content-box;
	width: 600px;
	height: 400px;
	word-break:break-all;
}
div#wrapper {
	position: absolute;
	top:50%;
	left:50%;
}	
</style>
<body>
<%@ include file="view/header.jsp" %>
<form action="boardRegister.do" method="post" style="border:1px soild #ccc">
		<input type="hidden" name="user_idx" value="${vo.userIdx}">

    	<div class="head-list">
            <table id="table_header">
            	<tr>
	                <td colspan=2><b>번호 : ${board.boardIdx}</b></td><br>
	            </tr>
	                <td><h2>${board.title}</h2></td>
	                <td>${board.registerDatetime}<td>
	            </tr>
            </table>
        </div>
     	<hr>   
    	<div class="bb">
    		<div id="question">	
    			${board.question}
    		</div>
    		<hr>
            <c1>
                <input type="button" name="answer1" maxlength="10" value="${board.answer1}" style="width: 200px"; required>
                VS
                <input type="button" name="answer2" maxlength="10" value="${board.answer1}" style="width: 200px"; required>
            </c1>
    	</div>
</form>
<%@ include file="view/footer.jsp" %>
</body>
</html>
</html>
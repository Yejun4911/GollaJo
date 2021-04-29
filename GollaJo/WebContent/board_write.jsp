<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
input[type=text], [type=textarea]{
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
        border: 2px solid #dddddd;
        border-radius: 5px;   
        top:50%;
		left:50%;    
      }
      
      .cb {     	
        box-sizing: content-box;
        width:70%;
        margin: 0 auto;        
      }
      .bb {
        box-sizing: content-box;
        height: 490px;
   		margin:0 auto;
   		width:70%;
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
    	<div class="cb">
      		<input type="text" placeholder="제목을 입력하세요" name="title" maxlength="50" style="width: 690px;" ; required>
    	</div>
    	<div class="bb">
      		<td><input type="textarea" placeholder="글을 입력하세요"  name="question" maxlength="2040"></textarea></td>
          <hr>
            <c1>
                <input type="text" placeholder="선택지1" name="answer1" maxlength="10"  style="width: 200px"; required>
                VS
                <input type="text" placeholder="선택지2" name="answer2" maxlength="10"  style="width: 200px"; required>
            </c1>
    	</div>
    			<button type="upload" class="uploadbtn btn-primary pull-right" value="upload">올리기</button>	
</form>
<%@ include file="view/footer.jsp" %>
</body>
</html>
</html>
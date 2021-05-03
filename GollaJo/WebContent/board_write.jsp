<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<style type="text/css">
	input[type=text]{
		border: none;	
		outline:none;
		margin:0 auto;
	}	
	textarea[name=answer1]{
		border: 5px solid rgb(231, 76, 60);
		margin-right: 40px;
	}	
	textarea[name=answer2]{
		border: 5px solid rgb(46, 204, 113);
		margin-left: 40px;
	}
	
	textarea[name=answer1], [name=answer2]{
		height:170px;
		width: 280px;
		border-radius: 5px; 
		font-size : 15px;
		font-color : gray;
		font-weight : bold;
		display:inline-block;
		cursor: pointer;
		text-align:center;
   	 	vertical-align:middle;
    	margin-bottom: 35px;
		margin-top: 35px;
		margin-left: 20px;
		resize: none;
	}	
	

	textarea#contenttext{
		height: 65%;
		border:none;	
		outline:none;
		margin:0 auto;
		top: 55%;
		left: 55%;
		width: 85%;
	}
	#contentchoice1{
		padding: 55px 20px;
	}
	#contentchoice2{
		padding: 55px 20px;
	}
	
	span{
		margin-top: -200px;
		font-size: 30px;
      	text-style: bold;
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
      
      
     .all{
      	top:35%;
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
      
      .content{
      	box-sizing: content-box;
      	height: 200px;
      	margin: -15px 0 30px 215px;
      	width: 70%;
      }
   
      .choice{
      	margin: -15px 20px 10px 20px;
      	vertical-align: middle;
      }
      
      .button{
      	border: none;
      	margin: -30px 10px 15px 1150px ;
      }
      
      .uploadbtn{
      	  font-size: 20px;
      	  padding: 10px 10px;
      	  width: 120px;
      	  height: 40px;
      	  border: 2px solid grey;
      	  color: grey;
      	  background-color: #dcdcdc;
      	  border-radius: 5px;

      }


      div> bb > c1{
        box-sizing: content-box;
        width: 600px;
        height: 400px;
        word-break:break-all;
        display:inline-block;
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
	<div class="all">
    	<div class="cb">
      		<input type="text" placeholder="제목을 입력하세요" name="title" maxlength="50" style="width: 690px;"  required>
   		</div>
            <div class ="choice" style="text-align:center;border:0;">
               <textarea id="contentchoice1"  type="text" placeholder="선 택 1&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer1" maxlength="10" ; required></textarea>
          			<span><strong>VS</strong></span>
               <textarea id="contentchoice2" type="text" placeholder="선 택 2&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer2" maxlength="10"; required></textarea>
    	</div>
    	
    	<div class ="content">
      		<textarea id="contenttext" wrap="virtual" rows=35 cols=160 placeholder="글을 입력하세요"  name="question" maxlength="2040" ></textarea>
		</div>

    	<div class="button">
    		<button type="submit" class="uploadbtn btn-primary pull-right" value="upload" style="cursor:pointer">올리기</button>	
    	</div>
	</div>
</form>
<%@ include file="view/footer.jsp" %>
</body>
</html>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0">
<!DOCTYPE html>


<style type="text/css">
	input[type=text]{
		border: none;	
		outline:none;
		margin:0 auto;
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
		border:none;	
		outline:none;
		margin: 1% 1% 1% 1%;
		width: 99%;
		height: 93%;

	}

	span{
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
        margin: 1% 1% 1% 13.5%;   
      }

      
      .content{
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
      	margin: 0.03% 1% 0.3% 78% ;

      }
      
      .uploadbtn{
      	  font-size: 20px;
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

</style>
<body>
<%@ include file="../view/header.jsp" %>
<form action="${pageContext.request.contextPath}/boardRegister.do" method="post" style="border:1px soild #ccc">
		<input type="hidden" name="user_idx" value="${vo.userIdx}">
	<div class="all">
    	<div class="cb">
      		<input type="text" placeholder="제목을 입력하세요" name="title" maxlength="50" style="width:95%;"  required>
   		</div>
            <div class ="choice" style="text-align:center;border:0;">
               <textarea id="contentchoice1"  type="text" placeholder="선 택 1&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer1" maxlength="10" ; required></textarea>
          			<span><strong>VS</strong></span>
               <textarea id="contentchoice2" type="text" placeholder="선 택 2&#13;&#10;&#13;&#10;결정이 필요한 사항을 입력해주세요." name="answer2" maxlength="10"; required></textarea>
    	</div>
    	
    	<div class ="content">
      		<textarea id="contenttext" wrap="virtual" placeholder="글을 입력하세요"  name="question" maxlength="2040" ></textarea>
		</div>

    	<div class="button">
    		<button type="submit" class="uploadbtn btn-primary pull-right" value="upload" style="cursor:pointer">올리기</button>	
    	</div>
	</div>
</form>
<%@ include file="../view/footer.jsp" %>
</body>
</html>
</html>
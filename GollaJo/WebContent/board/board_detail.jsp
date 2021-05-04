<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
	// 차트 데이터 설정
	
	var data = google.visualization.arrayToDataTable([
          ['${board.answer1}', '${board.answer2}'],
          ['${board.answer1}', ${percent1}],
          ['${board.answer2}', ${percent2}],
    ]);

	/* var data = new google.visualization.DataTable();
	data.addColumn('string','YES');
	data.addColumn('string','NO');
	data.addRow([1,2]);		      	
  	 */
	var options = {
  		legend: { position: "none" },
  		 hAxis:{
  			 title:"",
  			gridlines: {count: 0},
  		},
  		vAxis: { 
            gridlines: { count: 0 },
            "textStyle": {
              "color": 'white',
            }
        }
  		
	};
	 var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

     chart.draw(data, google.charts.Bar.convertOptions(options));
}
</script>
<script>
$(function() {
	var userIdx = 0;
    $('input[name=answer1]').click(function() {
    	userIdx = ${vo.userIdx};
        $.ajax({
            type: "post",
            url: "boardVote.do",
            data: {
                "user_idx": userIdx,
                "board_idx": ${board.boardIdx},
                "vote": 1
                },
            success: function(result) {
                if (result == "false") {
                    alert("이미 투표하셨습니다.")
                } else {
                    location.reload();
                }
            }
        });
    });
    $('input[name=answer2]').click(function() {
    	userIdx = ${vo.userIdx};
        $.ajax({
            type: "post",
            url: "boardVote.do",
            data: {
                "user_idx": userIdx,
                "board_idx": ${board.boardIdx},
                "vote": 2
                },
            success: function(result) {
                if (result == "false") {
                    alert("이미 투표하셨습니다.")
                } else {
                    location.reload();
                }
            }
        });
    });
    $('#comment-box>button').click(function() {
    	var input = $(this).parent().children()[0];
    	userIdx = ${vo.userIdx};
    	$.ajax({
    		type: "post",
    		url: "commentWrite.do",
    		data: {
    			"user_idx": userIdx,
    			"board_idx": ${board.boardIdx},
    			"comment": input.value
    		},
    		success: function(result) {
   				input.value = "";
   				input.focus();
   				var comment = JSON.parse(result);
   				location.reload();
   				/* $('#com').prepend(
   					"<p>"+ comment.nickname + "<span class='like-count'>추천" + comment.likes + "</span></p>" + comment.comment + "</td></tr>"
   				); */
    		}
    	});
    })
    $('.comment-update').click(function() {
    	var commentBox = $(this).parent().parent().children('.comment-comment');
    	commentBox.html("<input type='text' required></input><input class='comment-update-submit' type='submit' value='완료'>");
    })
    $('.comment-comment').on('click', '.comment-update-submit', function() {
    	var input = $(this).parent().find("input[type=text]").val();
    	var commentIdx = $(this).parent().parent().find(".comment-update").attr('value');
    	var comment = $(this).parent().find('.comment-comment');
    	$.ajax({
    		type: "post",
    		url: "commentUpdate.do",
    		data: {
    			"comment_idx": commentIdx,
    			"comment": input.value
    		},
    		success: function(result) {
    	    	comment.html(input.value);
    		}
    	});
    })
    $('.comment-delete').click(function() {
    	var commentIdx = $(this).attr('value');
    	var tr = $(this).parent().parent();
    	userIdx = ${vo.userIdx};
    	$.ajax({
    		type: "post",
    		url: "commentDelete.do",
    		data: { "comment_idx": commentIdx },
    		success: function(result) {
    			tr.remove();
    		}
    	});
    })
    $('.comment-like').click(function() {
    	userIdx = ${vo.userIdx};
    	var commentIdx = $(this).parent().parent().find('.comment-update').attr('value');
    	var likeCount = $(this).parent().find('.like-count');
    	$.ajax({
    		type: "post",
    		url: "commentLike.do",
    		data: {
    			"user_idx": userIdx,
    			"comment_idx": commentIdx
    		},
    		success: function(result) {
    			if (result) {
    				likeCount.text(Number(likeCount.text()) + 1);
    			} else {
    				alert("이미 좋아요한 댓글입니다.");
    			}
    		}
    	})
    })
})
</script>
 
<%@ include file="../view/header.jsp" %>
<style type="text/css">

#content {
    margin: 0 auto;
    padding: 10px;
    max-width: 70%;
    max-height:  80%;
}

.wrap {
    padding-top: 50px;
    widht: 100%;
    margin: 0 auto;
}

.title_table{

    box-sizing: content-box;
    margin:0 auto;
    padding-top: 30px;
    border-radius: 5px;
    position: relative;
    width: 100%;
    height: 30%;
}

.context_table {
    box-sizing: content-box;
    margin:0 auto;
    border: 2px solid #dddddd;
    border-radius: 5px;
    position: relative;
    width: 100%;
    height: 100%;
}

#chart{
    display:flex;
    align-items: center;
    justify-content: center;
}

#buttons{
    text-align: center;
    margin-top:10px;
    margin-bottom: 50px;
}
#question{
    padding:5px;
}
#chart>#columnchart_material{
    display:flex;
    align-items: center;
    justify-content: center;
    width:40%;
    height:20%;
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
    border: none;
    font-size: 25px;
    display:inline-block;
    cursor: pointer;
    text-align:center;
    vertical-align:middle;
    margin : 0 20px;
    margin-bottom: 20px;
}
#comment{ 
    margin:0 auto;
    padding:10px;
    vertical-align:middle;
    width:70%;
    padding:20px;
    top:80%;
    
}
#comment-box{
    display:inline;
    margin-left:-10px;
}
#comment-box > button{
    hover: #41A541;
}
.container-board{
    width:100%;
    margin:0 auto;
    left:70%;
}
#comment > table{
    padding:10px;
    width:100%;a
    border-top: 1px solid #444444;
    border-collapse: collapse;
}
#comment > table > thead,td{
    border-bottom: 1px solid #444444;
    background-color:white;
    color:black;
    padding: 10px;

}
button class > comment-delete{
    align:right;
}
#cline{
	height: 4px;
}
#com{
	padding:10px;
}
.comment-comment{
	padding:5px;
}
</style>
</head>
<body>
<form action="boardRegister.do" method="post" id=content>
    <input type="hidden" name="user_idx" value="${vo.userIdx}">
        <div class = "wrap">
            <div class = "title_table">
                <h2>${board.title}</h2>
                <hr>
                <p>${board.nickname} ${board.registerDatetime} 조회수 ${board.viewCount}</p>
            </div>

            <div class = "context_table">
                <div id="question">
                    ${board.question}
                </div>
                <div id="buttons">
                    <input type="button" name="answer1" maxlength="10" value="${board.answer1}" style="width: 15%"; required>
                    <font size="10"><b>VS</b></font>
                    <input type="button" name="answer2" maxlength="10" value="${board.answer2}" style="width: 15%"; required>
                </div>
                <div id="chart">
                    <div id="columnchart_material"></div>
                </div>
            </div>

        </div>
</form>
<div class="container-board" id="comment">
<div id="comment-box">
        <input type="text" placeholder="댓글을 작성하세요" name="comment" maxlength="40" style="width:95%; height:50px;" required>
         <button type="submit" style="width:5%; height:50px;" >올리기</button>
</div><br><br><br>
    	<hr id = "cline">
	    <c:forEach items="${commentList}" var="comment">
	    	<div id="com">
		           <p>${comment.nickname} <button class="comment-update" value="${comment.commentIdx}">수정</button>
		           <button class="comment-delete" value="${comment.commentIdx}">삭제</button></p> 
		           <p class="comment-comment">${comment.comment}</p>
		           <a class="comment-like" href="#a"><img src="${pageContext.request.contextPath}/image/heart.png" width="15" hieght="15"></a><span class="like-count"> ${comment.likes}</span>
		    	   <hr>	
		    </div>
		   
	    </c:forEach>
        
</div>
<%@ include file="../view/footer.jsp" %>
</body>
</html>
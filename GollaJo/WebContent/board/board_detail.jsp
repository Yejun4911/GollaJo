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
  		 hAxis:{title:""},
	};
	 var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

     chart.draw(data, google.charts.Bar.convertOptions(options));
}
</script>
<script>
$(function() {
    $('input[name=answer1]').click(function() {
        $.ajax({
            type: "post",
            url: "boardVote.do",
            data: {
                "user_idx": ${vo.userIdx},
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
        $.ajax({
            type: "post",
            url: "boardVote.do",
            data: {
                "user_idx": ${vo.userIdx},
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
    border : none;
    font-size : 25px;
    display:inline-block;
    cursor: pointer;
    text-align:center;
    vertical-align:middle;
    margin : 0 20px;
    margin-bottom: 20px;
}
#comment{ 
	padding:20px;
	top:80%;
	word-break:;
	vertical-align:middle;	
}
.commentbox>input{
	width:70%;
	
}
.container-board{
	width:70%;
	margin:0 auto;
	left:70%;

}
.container-board>table{
	border-spacing:10%;
	width:100%;
	margin:10px auto;
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
<form class="container-board" id="comment">
<div id="comment-box">
        <input type="text" placeholder="댓글을 작성하세요" name="comment" maxlength="40" style="width:100%; height:50px;" required>
        <button type="submit" style="margin:10px 10px 10px 800px ;">올리기</button>
</div>
    <table>
          <thead>
              <tr>
                  <th align="left" width="30%"><b>작성자</b></th>
                  <th align="left" width="40%"><b>댓글</b></th>
                  <th align="right" width="30%"><b>좋아요</b></th>
             </tr>
         </thead>
    <tbody>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.nickname}</td>
                <td>${comment.comment}</td>
                <td>${comment.likes}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</form>
<%@ include file="../view/footer.jsp" %>
</body>
</html>
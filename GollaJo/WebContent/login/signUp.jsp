<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0">
@font-face {
    src: url("fonts/08SeoulNamsanM_0.ttf"); 
  	font-family: "SeoulNamsanM";
}

* {
	box-sizing: 100%;
	font-family:"SeoulNamsanM";
}
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  display : block;
  border-radius: 5px;
}
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
button {
  background-color:rgb(231, 76, 60);
  color: white;
  padding: 10px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  border-radius: 5px;
  font-size : 17px;
}
button:hover {
  opacity:1;
}
.content {
	position: absolute; 
	padding: 20px; 
	width: 500px; 
	top: 50%; 
	left: 50%; 
	transform: translate(-50%, -50%);
	border:1px solid #ccc; 
	border-radius: 5px;"
}

</style>
<script type="text/javascript">
	function pwd2Check() {
		//비밀번호가 일치하지 않으면 페이지 이동 안되도록...
		//메세지 띄워주고
		var f = document.registerForm; // form name="registerForm"
		if(f.pwd.value != f.pwd2.value){
			alert("비밀번호가 일치하지 않습니다");
			f.pwd2.value="";
			f.pwd2.focus();
			return false;
		}
	}

	var xhr;
	var resultView;
	
	function idCheck() {
		var id = document.registerForm.id.value;
		var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
		var koreanCheck = /[a-zA-Z]/;
		resultView = document.getElementById("idCheckResult");
		if (id.length < 5 || id.length > 20) {
			resultView.innerHTML = "<font color='red'> 아이디는 5~20 글자!!</font>";
			return;
		}
		else if (specialCheck.test(id)) {
			resultView.innerHTML = "<font color='red'> 특수문자 불가능 </font>";
			return;
		}
		else if (!koreanCheck.test(id)) {
			resultView.innerHTML = "<font color='red'> 한글 불가능 </font>";
			return;
		}
		// 4글자 이상이면 비동기통신으로 로직을 전개시킨다.
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = idCallback;
		xhr.open("post", "idCheck.do", true)
		xhr.setRequestHeader("Content-Type", 
				"application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("id=" + id);
	}
	function idCallback() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var flag = xhr.responseText;
			resultView = document.getElementById("idCheckResult");
			if (flag == 'true')
				resultView.innerHTML = "<font color='red'><b> 사용 불가!!</b></font>";
			else
				resultView.innerHTML = "<font color='green'><b> 사용 가능!!</b></font>";
		}
	}
	
	function nicknameCheck() {
		var nickname = document.registerForm.nickname.value;
		resultView = document.getElementById("nicknameCheckResult");
		if (nickname.length < 2 || nickname.length > 10) {
			resultView.innerHTML = "<font color='red'>닉네임은 2~10 글자!!</font>";
			return;
		}
		
		// 4글자 이상이면 비동기통신으로 로직을 전개시킨다.
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = nicknameCallback;
		xhr.open("post", "nicknameCheck.do", true)
		xhr.setRequestHeader("Content-Type", 
				"application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("nickname=" + nickname);
	}
	function nicknameCallback() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var flag = xhr.responseText;
			resultView = document.getElementById("nicknameCheckResult");
			if (flag == 'true')
				resultView.innerHTML = "<font color='red'><b> 닉네임 사용 불가!!</b></font>";
			else
				resultView.innerHTML = "<font color='green'><b> 닉네임 사용 가능!!</b></font>";
		}
	}
	
	function pwdCheck() {
		var pwd = document.registerForm.pwd.value;
		resultView = document.getElementById("pwdCheckResult");
		if (pwd.length < 8 || pwd.length > 20) {
			resultView.innerHTML = "<font color='red'>비밀번호는 8~20 글자!!</font>";
			return;
		}else{
			resultView.innerHTML = "<font color='green'>사용 가능 !</font>";
			
		}
	}
</script>
<body>
<%@ include file="../view/header.jsp" %>
<form action="${pageContext.request.contextPath}/signUp.do" method="post" name="registerForm" onsubmit="return pwd2Check()">
  <div class="content">
  	<h2>로그인</h2><hr>
    <label for="아이디"><b>아이디</b></label><span id="idCheckResult"></span>
    <input type="text" placeholder="아이디" name="id" required onkeyup="idCheck()">
    <label for="비밀번호"><b>비밀번호</b></label><span id="pwdCheckResult"></span>
    <input type="password" placeholder="비밀번호" name="pwd" required onkeyup="pwdCheck()">
    <label for="비밀번호확인"><b>비밀번호확인</b></label>
    <input type="password" placeholder="비밀번호확인" name="pwd2" required>
    <label for="닉네임"><b>닉네임</b></label><span id="nicknameCheckResult" ></span>
    <input type="text" placeholder="닉네임" name="nickname" required onkeyup="nicknameCheck()">
    
    
    <div class="clearfix">
      <button type="Login" class="signupbtn">회원가입</button>
    </div>
  </div>
</form>
<%@ include file="../view/footer.jsp" %>
</body>
</html>
</html>
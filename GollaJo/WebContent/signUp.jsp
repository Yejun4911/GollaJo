<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
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
  background-color: red;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

.container {
  padding: 16px;
}

</style>
<body>

<form action="#" style="border:1px solid #ccc">
  <div class="container">
    <h1>회원가입</h1>
    <hr>

    <label for="아이디"><b>ID</b></label>
    <input type="text" placeholder="ID" name="아이디" required>

    <label for="비밀번호"><b>Password</b></label>
    <input type="password" placeholder="PASSWORD" name="비밀번호" required>

    <label for="비밀번호 확인"><b>Repeat Password</b></label>
    <input type="password" placeholder="PASSWORD" name="비밀번호 확인" required>
    
    <label for="닉네임"><b>NickName</b></label>
    <input type="text" placeholder="NICKNAME" name="닉네임" required>

    <div class="clearfix">
      <button type="회원가입" class="signupbtn">회원가입</button>
    </div>
  </div>
</form>

</body>
</html>
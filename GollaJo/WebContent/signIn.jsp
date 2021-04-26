<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: 50%;
	}
input[type=text], input[type=password] {
  width: 30%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  display : block;
}
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

button {
  background-color: red;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.9;
}
button:hover {
  opacity:1;
}
.container {
  margin : auto auto;
  width : 50%;
  padding: 16px;
}
</style>
<body>
<form action="/action_page.php">
  <div class="container">
    <label for="아이디"><b>ID</b></label>
    <input type="text" placeholder="ID" name="아이디" required>
    <label for="비밀번호"><b>PASSWORD</b></label>
    <input type="password" placeholder="PASSWORD" name="비밀번호" required>
    <div class="clearfix">
      <button type="Login" class="signupbtn">Login</button>
    </div>
  </div>
</form>
</body>
</html>
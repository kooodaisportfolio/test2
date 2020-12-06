<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>美容室管理システム</title>
<link rel="stylesheet" href="./css/animate.min.css">
</head>
<body>
	<div style="text-align:center">
		<h1 class="animate__animated animate__flip animate__slower">美容室営業管理システム</h1>
		<%= new java.util.Date() %>
		<% String userName = (String) request.getAttribute("userName"); %>
	    <p>こんにちは、${userName}さん！</p>
	    <form method="post" action="./main">
		    <div>
		        <span>お客様名:</span><input type="text" name="name">
		        <br>
		        <span>施術時間:</span><input type="text" name="time">
		        <br>
		        <span>料金:</span><input type="text" name="fee">
		    </div>
		        <button type="submit">登録</button>
		    <div>
		    </div>
	    </form>
    </div>
</body>
</html>
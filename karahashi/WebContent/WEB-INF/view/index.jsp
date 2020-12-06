<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>美容室管理システム</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css">
</head>
<body>
	<div style="text-align:center; width:80%; margin-left: auto; margin-right: auto;">
		<h1 class="animate__animated animate__rubberBand animate__slower animate__infinite" style="font-family:fantasy; font-size:100px;">Beaty Salon System</h1>
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
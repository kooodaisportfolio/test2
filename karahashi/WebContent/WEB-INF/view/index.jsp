<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= new java.util.Date() %>
	<%= request.getAttribute("userName") %>
	${userName}

	<% String userName = (String) request.getAttribute("userName"); %>
    こんにちは、<%= userName %> さん！

	 <% if ("Guest".equals(userName)) { %>
    <form method="post" action="./main">
        名前を入力してください: <input type="text" name="name">
        <button type="submit">送信</button>
    </form>
    <% } %>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: onam-ui
  Date: 24. 9. 15.
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%-- 상대 경로 사용, [현재 URL 이 속한 계층 경로 + /save] --%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/26/2019
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

RESULT:
<%
    out.println(request.getParameter("result"));
%>

</body>
</html>

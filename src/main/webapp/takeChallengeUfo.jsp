<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 24.03.2024
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<%
    String message1 = (String) request.getAttribute("message1");
    String message2 = (String) request.getAttribute("message2");
    String message3 = (String) request.getAttribute("message3");
    String message4 = (String) request.getAttribute("message4");
    if (message1 != null) {
        out.println("<h2>" + message1 + "</h2>");
    }
    if (message2 != null) {
        out.println("<h2>" + message2 + "</h2>");
    }
%>
<form method=post action=/take-challenge>
    <%

        if (message3 != null) {
            out.println("<input type=submit value=" + message3 + ">");
        }
    %>
</form>
<form method="post" action=/reject-challenge>
    <%
        if (message4 != null) {
            out.println("<input type=submit value=" + message4 + ">");
        }
    %>
</form>
</body>
</html>

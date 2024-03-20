<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 25.03.2024
  Time: 13:57
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
    if (message1 != null) {
        out.println("<h1>" + message1 + "</h1>");
    }
    if (message2 != null) {
        out.println("<h2>" + message2 + "</h2>");
    }

%>
<form method="post" action="/servlet1">
    <%
        if (message3 != null) {
            out.println("<input type=\"submit\" value=\"" + message3 + "\">");
        }
    %>
</form>
</body>
</html>

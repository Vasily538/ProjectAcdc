<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 25.03.2024
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<%
    String message1 = (String) request.getAttribute("message1");
    if (message1 != null) {
        out.println("<h2>" + message1 + "</h2>");
    }
%>
<form method="post" action="/went-up-to-the-bridge">
    <%
        out.println("<input type=submit value=" + message1 + ">");
    %>
</form>

<%
//    HttpSession session1 = request.getSession();
//    out.println("<h2>" + "IP address: " + session1.getAttribute("ip") + "</h2>");
//
//    out.println("<h2>" + "Имя в игре: " + session1.getAttribute("name") + "</h2>");
//
//    out.println("<h2>" + "Количество игр: " + session1.getAttribute("count") + "</h2>");
%>

</body>
</html>

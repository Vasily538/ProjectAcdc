<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 25.03.2024
  Time: 11:14
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
  String message5 = (String) request.getAttribute("message5");
  String message6 = (String) request.getAttribute("message6");
  String message7 = (String) request.getAttribute("message7");
  Integer count = (Integer) request.getAttribute("count");
  if (message1 != null) {
    out.println("<h2>" + message1 + "</h2>");
  }
  if (message2 != null) {
    out.println("<h1>" + message2 + "</h1>");
  }
%>
<form method="post" action="/go-up-to-the-bridge">
  <%
    if (message3 != null) {
      out.println("<input type=submit value=" + message3 + ">");
    }
  %>
    </form>
<form method="post" action="/reject-go-up-to-the-bridge">
  <%
    if (message4 != null) {
      out.println("<input type=submit value=" + message4 + ">");
    }
  %>
    </form>
<%
  if (message5 != null) {
    out.println("<h2>" + message5 + "</h2>");
  }
  if (message6 != null) {
    out.println("<h2>" + "IP address: " + message6 + "</h2>");
  }
  if (message7 != null) {
    out.println("<h2>" + "Имя в игре: " + message7 + "</h2>");
  }
  if (count != null) {
    out.println("<h2>" + "Количество игр: " + count + "</h2>");
  }
%>
</body>
</html>

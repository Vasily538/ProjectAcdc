<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 23.03.2024
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

</head>
<body>
<%
  String message1 = (String) request.getAttribute("message1");
  if (message1 != null) {
    out.println("<h1>" + message1 + "</h1>");
  }
  String message2 = (String) request.getAttribute("message2");
  if (message2 != null) {
    out.println("<h2>" + message2 + "</h2>");
  }
  String message3 = (String) request.getAttribute("message3");
  if (message3 != null) {
    out.println("<h1>" + message3 + "</h1>");
  }
  String message4 = (String) request.getAttribute("message4");
  if (message4 != null) {
    out.println("<h2>" + message4 + "</h2>");
  }
%>


<form method="post" action="/introduce-servlet">
  <input type="text" id="fname" name="fname">
  <%
    String message5 = (String) request.getAttribute("message5");
    if (message5 != null) {
      out.println("<input type=submit value=" + message5 + ">");
    }
  %>
</form>
</body>
</html>

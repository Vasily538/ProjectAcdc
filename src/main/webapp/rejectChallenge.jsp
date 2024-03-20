<%--
  Created by IntelliJ IDEA.
  User: Анкудинов
  Date: 25.03.2024
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String message1 = (String) request.getAttribute("message1");
        String message2 = (String) request.getAttribute("message2");
        if (message1 != null) {
            out.println("<h2>" + message1 + "</h2>");
        }
        if (message2 != null) {
            out.println("<h1>" + message2 + "</h1>");
        }
    %>
    <form method="post" action="/servlet1">
        <%
            String message3 = (String) request.getAttribute("message3");
            if (message3 != null) {
                out.println("<input type=\"submit\" value=\"" + message3 + "\">");
            }
        %>
    </form>

</head>
<body>
<%
    HttpSession session1 = request.getSession();
    out.println("<h2>Статистика:</h2>");

    out.println("<h2>" + "IP address: " + session1.getAttribute("ip") + "</h2>");

    out.println("<h2>" + "Имя в игре: " + session1.getAttribute("name") + "</h2>");

    out.println("<h2>" + "Количество игр: " + session1.getAttribute("count") + "</h2>");
%>
</body>
</html>

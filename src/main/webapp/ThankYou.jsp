<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Thank You</title>
</head>
<body>
<%
   
    String name = (String) session.getAttribute("name");
    String feedback = (String) session.getAttribute("feedback");
%>
    <h1>Thank You!</h1>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Feedback:</strong> <%= feedback %></p>
</body>
</html>

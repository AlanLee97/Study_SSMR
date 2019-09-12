<%@ page import="com.study.pojo.Role" %><%--
  Created by IntelliJ IDEA.
  User: AlanLee
  Date: 2019/8/10
  Time: 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SessionAttributes 和 SessionAttribute</title>
</head>
<body>
<%
    Role role = (Role) session.getAttribute("role");
    out.println("id = " + role.getId() + "</br>");
    out.println("roleName = " + role.getRoleName() + "</br>");
    out.println("note = " + role.getNote() + "</br>");

    int id = (int) session.getAttribute("id");
    out.println("id = " + id);
%>
</body>
</html>

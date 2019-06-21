<%@ page import="java.util.List" %>
<%@ page import="entity.ClassRoom" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/21/2019
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ClassRoom> list =(List<ClassRoom>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Account List</h1>
<ul>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <li><%= list.get(i).getName()%> - <%= list.get(i).getEmail()%></li>
    <%
        }
    %>

</ul>
</body>
</html>

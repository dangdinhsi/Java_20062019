<%@ page import="entity.ClassRoom" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/21/2019
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClassRoom room = (ClassRoom) request.getAttribute("room");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null){
        errors = new HashMap<>();
    }
    if(room == null){
        room = new ClassRoom();
    }
%>
<style>
    .error {
        color: red;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Classroom Form</h1>
<div></div>
<%
    if(errors.size() > 0){
%>
<div class="error">
    Vui lòng sửa các lỗi bên dưới và thử lại.
</div>
<%
    }
%>

<div>
    <br>
</div>

<form action="/classroom/create" method="post">
    <div>
        Name <input type="text" name="name" value="<%= room.getName()%>">
        <%
            if(errors.containsKey("name")){
        %>
        <span class="error"><%=errors.get("name")%></span>
        <%
            }
        %>
    </div>
    <div>
        Pass <input type="text" name="password" value="<%= room.getPassword()%>">
        <%
            if(errors.containsKey("password")){
        %>
        <span class="error"><%=errors.get("password")%></span>
        <%
            }
        %>
    </div>
    <div>
       Re-Pass <input type="text" name="password2" value="<%= room.getPassword2()%>">
        <%
            if(errors.containsKey("password2")){
        %>
        <span class="error"><%=errors.get("password2")%></span>
        <%
            }
        %>
    </div>
    <div>
        Description <input type="text" name="description" value="<%= room.getDescription()%>">
        <%
            if(errors.containsKey("description")){
        %>
        <span class="error"><%=errors.get("description")%></span>
        <%
            }
        %>
    </div>
    <div>
        Email <input type="text" name="email" value="<%= room.getEmail()%>">
        <%
            if(errors.containsKey("email")){
        %>
        <span class="error"><%=errors.get("email")%></span>
        <%
            }
        %>
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>

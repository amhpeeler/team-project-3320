<%-- 
    Document   : application.
    Created on : Apr 24, 2024, 3:43:15 PM
    Author     : Milton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Application Page</title>
    </head>
    <body>
        <h1>Project Application: ${param.projectTitle}</h1>
        <form action="applyCTL" method="post">
        <input type="hidden" name="projectId" value="${param.projectId}">
        <label for="username">Enter your username:</label><br>
        <textarea id="username" name="username" rows="1" cols="50"></textarea><br> 
        <label for="comment">Enter your comment:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Apply">
        </form>
    </body>
</html>

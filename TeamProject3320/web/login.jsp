<%-- 
    Document   : login
    Created on : Apr 17, 2024, 9:05:29 PM
    Author     : celso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Please Enter Username and Password</h1>
        <form action="loginCTL" method="post">
            <div class="heading_container">
                Username:
                <input type="text" name="username" class="btn"/><br>
            <div/>
            <div class="heading_container">
                Password:
                <input type="password" name="password" class="btn"/><br>
                <input type="submit" value="login" class="btn">
            <div/>
        </form>
    </body>
</html>

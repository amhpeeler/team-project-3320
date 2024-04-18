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
    </head>
    <body>
        <h1>Please Enter Username and Password</h1>
        <form action="loginCTL" method="post">
            <div>
                Username:
                <input type="text" name="username"/><br>
            <div/>
            <div>
                Password:
                <input type="text" name="password"/><br>
                <input type="submit" value="login">
            <div/>
        </form>
    </body>
</html>

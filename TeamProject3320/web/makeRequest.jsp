<%-- 
    Document   : makeRequest
    Created on : Apr 24, 2024, 3:04:45 PM
    Author     : annamariepeeler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Request</title>
    </head>
    <h1>Make Request for Project</h1>
    <body>
        <form action="makeRequestCTL" method="post">
            <input type=hidden name="projectid" value="${projectid}" readonly>
            <input type=hidden name="studentid" value="${studentid}" readonly>
            <input type=hidden name="mentorid" value="${mentorid}" readonly>
    
            <label for="message">Message:</label><br>
            <textarea id="message" name="message" rows="4" cols="50"></textarea><br>
    
            <input type="submit" value="Submit Request">
        </form>
    </body>
</html>

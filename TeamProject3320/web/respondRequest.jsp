<%-- 
    Document   : respondRequest
    Created on : Apr 24, 2024, 7:51:25 PM
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
        <form action="respondRequestCTL" method="post">
            <input type="hidden" name="id" value="${request.id}" readonly>
            Project title: ${request.title} <br>
            Student making request: ${request.student}<br>
            Mentor: ${request.mentor}<br>
            Request: ${request.request}<br>
            <hr>

            <label for="message">Message:</label><br>
            <textarea id="message" name="message" rows="4" cols="50"></textarea><br>
    
            <input type="submit" value="Submit Request">
        </form>
    </body>
</html>

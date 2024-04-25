<%-- 
    Document   : submitDeliverables
    Created on : Apr 25, 2024, 10:51:05 AM
    Author     : annamariepeeler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Deliverables</title>
    </head>
    <h1>Submit Deliverables</h1>
    <body>
        <form action="submitDeliverablesCTL" method="post">
            <input type=hidden name="projectid" value="${projectid}" readonly>
    
            <label for="message">Project Deliverables:</label><br>
            <textarea id="message" name="message" rows="4" cols="50"></textarea><br>
    
            <input type="submit" value="Submit Deliverables">
        </form>
    </body>
</html>

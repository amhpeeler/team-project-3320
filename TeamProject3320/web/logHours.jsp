<%-- 
    Document   : logHours
    Created on : Apr 25, 2024, 12:33:52 PM
    Author     : annamariepeeler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log Hours</title>
</head>
<body>
    <h1>Log Hours</h1>
    <form action="logHoursCTL" method="post">
        <label for="projectId">Project ID:</label>
        <input type="text" id="projectId" name="projectId" value="${projectid}" readonly><br><br>
        
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="${studentid}"readonly><br><br>
        
        <label for="hours">Hours:</label>
        <input type="number" id="hours" name="hours" min="1" required><br><br>
        
        <input type="submit" value="Log Hours">
    </form>
</body>
</html>

<%-- 
    Document   : projectDetails
    Created on : Apr 23, 2024, 10:29:29 PM
    Author     : annamariepeeler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Details</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body class="heading_container">
    <h1>Project Details</h1>
    
    <c:if test="${empty project}">
        <p>No project found.</p>
    </c:if>
    
    <c:if test="${not empty project}">
        <p>Title: <c:out value="${project.title}" /></p>
        <p>Type: <c:out value="${project.type}" /></p>
        <!-- Add more details as needed -->
        <form action="approveProjectCTL" method="post">
            <input type="submit" value="Approve"/>
        </form>
    </c:if>
</body>
</html>

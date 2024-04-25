<%-- 
    Document   : assignStudents
    Created on : Apr 25, 2024, 11:21:05 AM
    Author     : annamariepeeler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assign Students</title>
    </head>
    <body>
        <form action="assignStudentsCTL?" method="post">
            <select name="student1">
                <c:forEach items="${students}" var="s1">
                    <option value="${s1.studentID}">${s1.name}</option>
                </c:forEach>
            </select>
            <select name="student2">
                <c:forEach items="${students}" var="s2">
                    <option value="${s2.studentID}">${s2.name}</option>
                </c:forEach>
            </select>
            <select name="student3">
                <c:forEach items="${students}" var="s3">
                    <option value="${s3.studentID}">${s3.name}</option>
                </c:forEach>
            </select>
            <select name="student4">
                <c:forEach items="${students}" var="s4">
                    <option value="${s4.studentID}">${s4.name}</option>
                </c:forEach>
            </select>
            <select name="student5">
                <c:forEach items="${students}" var="s5">
                    <option value="${s5.studentID}">${s5.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Approve"/>
        </form>  
        
        <a href="mentorViewCTL">Back to Projects</a>
    </body>
</html>

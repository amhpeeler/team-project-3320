<%-- 
    Document   : studentProjects
    Created on : Apr 24, 2024, 12:17:27 PM
    Author     : annamariepeeler
    This page loads all the projects that the student is currently working on 
    and allows the student to click on a project to click on a project to view 
    details, send a request, and upload deliverables.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Projects</title>
    </head>
    <h1>Welcome, ${studentID}</h1>
    
    <h1>Projects to Work On:</h1>
    <c:choose>
        <c:when test="${empty studentProjects}">
            Not currently part of any projects.
        </c:when>
        <c:otherwise>
            <table>
                <tbody>
                    <c:forEach items="${studentProjects}" var="proj">
                        <tr>
                            <td><a href="studentProjectDetails?projectId=${proj.id}">${proj.title}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
            <br><!-- comment -->
            <a href="studentViewCTL">Back to projects</a>
</html>

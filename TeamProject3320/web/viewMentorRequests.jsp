<%-- 
    Document   : viewRequests
    Created on : Apr 24, 2024, 4:53:06 PM
    Author     : annamariepeeler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requests</title>
    </head>
    <body>
        <h1>Request History</h1>
    
        <c:if test="${empty requests}">
            <p>No requests found.</p>
        </c:if>
    
        <c:if test="${not empty requests}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Student</th>
                        <th>Mentor</th>
                        <th>Request</th>
                        <th>Response</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requests}" var="req">
                        <tr>
                            <td><c:out value="${req.title}" /></td>
                            <td><c:out value="${req.title}" /></td>
                            <td><c:out value="${req.student}" /></td>
                            <td><c:out value="${req.mentor}" /></td>
                            <td><c:out value="${req.request}" /></td>
                            <td><input type="text" name="response" value="${req.response}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <div>
            <nav>
                <div>
                    <a href="mentorViewCTL">Back to Projects</a>
                </div>
            </nav>
        </div>
    </body>
</html>

<%-- 
    Document   : mentorview
    Created on : Apr 23, 2024, 11:52:36 AM
    Author     : annamariepeeler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mentor</title>
</head>
<body>
    <h1>Welcome, Mentor ${mentorID}</h1>
    
    <h1>To Be Reviewed:</h1>
    <table>
        <tbody>
            <c:forEach items="${unreviewed}" var="uproj">
                <tr>
                    <td><c:out value="${uproj.title}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h1>Mentoring:</h1>
    <table>
        <tbody>
            <c:forEach items="${mentored}" var="ment">
                <tr>
                    <td><c:out value="${ment.title}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>


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
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
    <h1>Welcome, Mentor ${mentorID}</h1>
    
    <h1>To Be Reviewed:</h1>
    <table class="heading_container">
        <tbody>
            <c:forEach items="${unreviewed}" var="uproj">
                <tr>
                    <td class="heading_container"><a href="projectDetails?projectId=${uproj.id}">${uproj.title}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h1>Mentoring:</h1>
    <table>
        <tbody>
            <c:forEach items="${mentored}" var="ment">
                <tr>
                    <td class="heading_container"><a href="mentorProjectDetails?projectId=${ment.id}">${ment.title}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h1>Need Mentors:</h1>
    <table>
        <tbody>
            
        </tbody>
    </table>
</body>
</html>


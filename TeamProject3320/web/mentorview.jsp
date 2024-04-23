<%-- 
    Document   : mentorview
    Created on : Apr 23, 2024, 11:52:36 AM
    Author     : annamariepeeler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor</title>
    </head>
    <body>
        <h1>To Be Reviewed:</h1>
            <tbody>
                <c:forEach items="${unreviewed}" var="uproj">
                    <tr>
                        <td>
                            <c:out value="${uproj.getTitle()}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        <h1>Mentoring:</h1>
            <tbody>
                <c:forEach items="${mentored}" var="memb">
                    <tr>
                        <td>
                            <c:out value="${mproj.getTitle()}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
    </body>
</html>

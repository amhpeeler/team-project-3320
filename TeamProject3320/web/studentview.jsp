<%-- 
    Document   : studentview
    Created on : Apr 23, 2024, 8:15:43 PM
    Author     : joshroca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <h1>All Projects</h1>
        <table>
            <tbody>
            <c:forEach items="${projects}" var="proj">
                <tr>
                    <td>
                        <c:out value="${proj.getTitle()}" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>

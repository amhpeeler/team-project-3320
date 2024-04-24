<%-- 
    Document   : studentview
    Created on : Apr 23, 2024, 8:15:43 PM
    Author     : joshroca
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <h1>Approved Projects</h1>
        <table>
            <tbody>
            <c:forEach items="${projects}" var="proj">
                <tr>
                    <td> <c:out value="${proj.getTitle()}" /> </td>
                    <td> <c:out value="${proj.getId()}" /> </td>
                    <td> <c:out value="${proj.getType()}" /> </td>
                    <td> <c:out value="${proj.getSponsorCompany()}" /> </td>
                    <td> <c:out value="${proj.getContacts()}" /> </td>
                    <td> <c:out value="${proj.getAcademicYear()}" /> </td>
                    <td> <c:out value="${proj.getSkillsRequested()}" /> </td>
                    <td> <c:out value="${proj.getDisciplines()}" /></td>
                    <td> <c:out value="${proj.getNumOfStudents()}" /></td>
                    <td> <c:out value="${proj.getDeliverables()}" /></td>
                    <td><a href="application.jsp?projectId=${proj.id}" class="link">Project Details</a></td>
                </tr>
            </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>

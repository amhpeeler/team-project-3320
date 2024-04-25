<%-- 
    Document   : profilePage
    Created on : Apr 25, 2024, 10:09:45 AM
    Author     : celso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>Profile:</h1>
        <ul>
            <c:forEach items="${profile}" var="p">
                
                    <li> <c:out value="${p.fname}" /> <c:out value="${p.lname}"/></li>
                    <li> <c:out value="${p.phoneNumber}" /> </li>
                    <li> <c:out value="${p.emailAddress}" /> </li>
                    <li> <c:out value="${p.school}" /> </li>
                    <li> <c:out value="${p.year}" /> </li>
                    <li> <c:out value="${p.major}" /> </li>
                    <li><c:out value="${p.minor}" /> </li>
                    <li> <c:out value="${p.skills}" /></li>
                    <li> <c:out value="${p.pastExperiences}" /></li>
                
            </c:forEach>
        </ul> 
    <a href="updateProfile.jsp">Update Profile</a>
    
    </body>
</html>

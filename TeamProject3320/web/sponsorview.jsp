<%-- 
    Document   : sponsorview
    Created on : Apr 18, 2024, 6:36:02 PM
    Author     : celso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sponsor DashBoard</title>
    </head>
    <body>
        <section>
            <h1>Create a Project!</h1>
            <div>
                <form action="createProjectCTL" method="post">
                    <div>
                        Title:
                        <input type ="text" name="title"/><br>
                    </div>
                    <div>
                        Type:
                        <input type ="text" name="type"/><br>
                    </div>
                    <div>
                        Contacts:
                        <input type ="text" name="contacts"/><br>
                    </div>
                    <div>
                        Required Skills:
                        <input type ="text" name="skills"/><br>
                    </div>
                    <div>
                        Disciplines:
                        <input type ="text" name="discplines"/><br>
                    </div>
                    <div>
                        Number of Students:
                        <input type ="text" name="numOfStudents"/><br>
                    </div>
                    <div>
                        Description:
                        <input type ="text" name="description"/><br>
                    </div>
                    <div>
                        Required Deliverables:
                        <input type ="text" name="deliverables"/><br>
                    </div>
                    <div>
                        <input type="submit" value="Submit">
                    </div>
                    
                </form>
            </div>
        </section>
        <section>
            <h1>View Requested Projects</h1>
            <table>
            <thead>
            <th>Titles:</th>
            </thead>
            <tbody>
                <c:forEach items="${projects}" var="proj">
                    <tr>
                        <td>
                          <c:out value="${proj.getTitle()}"/>
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        
            
        </table>
        </section>
    </body>
</html>

<%-- 
    Document   : studentProjectDetails
    Created on : Apr 24, 2024, 2:46:10 PM
    Author     : annamariepeeler
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Details</title>
</head>
<body>
    <h1>Project Details</h1>
    
    <c:if test="${empty project}">
        <p>No project found.</p>
    </c:if>
    
    <c:if test="${not empty project}">
        <ul>
            <li>Title: <c:out value="${project.title}" /></li>
            <li>Type: <c:out value="${project.type}" /></li>
            <li>Sponsor Company: <c:out value="${project.sponsorCompany}" /></li>
            <li>Contacts: <c:out value="${project.contacts}" /></li>
            <li>Academic Year: <c:out value="${project.academicYear}" /></li>
            <li>Skills Requested: <c:out value="${project.skillsRequested}" /></li>
            <li>Disciplines: <c:out value="${project.disciplines}" /></li>
            <li>Number of Students: <c:out value="${project.numOfStudents}" /></li>
            <li>Deliverables: <c:out value="${project.deliverables}" /></li>
            <li>Number of Teams: <c:out value="${project.numOfTeams}" /></li>
            <li>Mentor: <c:out value="${project.mentor}" /></li>
            <li>Student 1: <c:out value="${project.student1}" /></li>
            <li>Student 2: <c:out value="${project.student2}" /></li>
            <li>Student 3: <c:out value="${project.student3}" /></li>
            <li>Student 4: <c:out value="${project.student4}" /></li>
            <li>Student 5: <c:out value="${project.student5}" /></li>
        </ul>
    </c:if>
        
    <div>
        <nav>
            <div>
                <a href="makeRequestCTL?projectId=${project.id}&amp;mentorId=${project.mentor}">Make a Request</a>
                <a href="viewRequestsCTL?projectId=${project.id}">View Requests</a>
                <a href="submitDelieverablesCTL">Submit Delieverables</a>
                <a href="submitDelieverablesCTL">Log Hours</a>
            </div>
        </nav>
    </div>
</body>
</html>

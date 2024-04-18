<%-- 
    Document   : register
    Created on : Apr 18, 2024, 2:05:13 PM
    Author     : annamariepeeler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dynamic Form</title>
<style>
    .hidden {
        display: none;
    }
</style>
</head>
<body>
    <label for="userType">Select User Type:</label>
    <select id="userType" onchange="showFields()">
        <option value="sponsor">Sponsor</option>
        <option value="student">Student</option>
        <option value="staff">Staff</option>
    </select>

    <div id="sponsorFields" class="hidden">
        <label for="sponsorName">Sponsor Name:</label>
        <input type="text" id="sponsorName" name="sponsorName"><br>
    </div>

    <div id="studentFields" class="hidden">
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName"><br>
    </div>

    <div id="staffFields" class="hidden">
        <label for="staffName">Staff Name:</label>
        <input type="text" id="staffName" name="staffName"><br>
    </div>

    <script>
        function showFields() {
            var userType = document.getElementById("userType").value;
            document.getElementById("sponsorFields").style.display = userType === "sponsor" ? "block" : "none";
            document.getElementById("studentFields").style.display = userType === "student" ? "block" : "none";
            document.getElementById("staffFields").style.display = userType === "staff" ? "block" : "none";
        }
    </script>
</body>
</html>


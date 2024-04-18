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
        <label for="sponsorFName">Sponsor First Name:</label>
        <input type="text" id="sponsorFName" name="sponsorFName" required><br>
        <label for="sponsorLName">Sponsor Last Name:</label>
        <input type="text" id="sponsorLName" name="sponsorLName" required><br>
        <label for="sponsorCompany">Sponsor Company:</label>
        <input type="text" id="sponsorCompany" name="sponsorCompany" required><br>
        <label for="sponsorUName">Sponsor Username:</label>
        <input type="text" id="sponsorUName" name="sponsorUName" required><br>
        <label for="sponsorPassword">Sponsor Password:</label>
        <input type="password" id="sponsorPassword" name="sponsorPassword" required><br>
        <label for="sponsorPhone">Sponsor Phone Number:</label>
        <input type="tel" id="sponsorPhone" name="sponsorPhone" required><br>
        <label for="sponsorEmail">Sponsor Email:</label>
        <input type="email" id="sponsorEmail" name="sponsorEmail" required><br>
        <label for="sponsorTitle">Sponsor Title:</label>
        <input type="text" id="sponsorTitle" name="sponsorTitle" required><br>
        
    </div>

    <div id="studentFields" class="hidden">
        <label for="studentFName">Student First Name:</label>
        <input type="text" id="studentFName" name="studentFName" required><br>
        <label for="studentLName">Student Last Name:</label>
        <input type="text" id="studentLName" name="studentLName" required><br>
        <label for="studentUName">Student Username:</label>
        <input type="text" id="studentUName" name="studentUName" required><br>
        <label for="studentPassword">Student Password:</label>
        <input type="password" id="studentPassword" name="studentPassword" required><br>
        <label for="studentPhone">Student Phone:</label>
        <input type="tel" id="studentPhone" name="studentPhone" required><br>
        <label for="studentEmail">Student Email:</label>
        <input type="email" id="studentEmail" name="studentEmail" required><br>
        <label for="studentSkills">Student Skills:</label>
        <input type="text" id="studentSkills" name="studentSkills" required><br>
        <label for="studentFName">Student Name:</label>
        <input type="text" id="studentFName" name="studentFName" required><br>
        <label for="studentYear">Student Academic Year:</label>
        <input type="text" id="studentYear" name="studentYear" required><br>
        <label for="studentMajor">Student Major:</label>
        <input type="text" id="studentMajor" name="studentMajor" required><br>
        <label for="studentMinor">Student Minor:</label>
        <input type="text" id="studentMinor" name="studentMinor"><br>
        <label for="studentSchool">Student School:</label>
        <input type="text" id="studentSchool" name="studentSchool" required><br>
        <label for="studentPast">Student Past Experiences:</label>
        <input type="text" id="studentPast" name="studentPast"><br>
    </div>

    <div id="staffFields" class="hidden">
        <label for="staffFName">Staff Name:</label>
        <input type="text" id="staffFName" name="staffFName"><br>
        <label for="staffLName">Staff Last Name:</label>
        <input type="text" id="staffLName" name="staffLName" required><br>
        <label for="staffUName">Staff Username:</label>
        <input type="text" id="staffUName" name="staffUName" required><br>
        <label for="staffPassword">Staff Password:</label>
        <input type="password" id="staffPassword" name="staffPassword" required><br>
        <label for="studentPhone">Staff Phone:</label>
        <input type="tel" id="staffPhone" name="staffPhone" required><br>
        <label for="staffEmail">Staff Email:</label>
        <input type="email" id="staffEmail" name="staffEmail" required><br>
        <label for="staffDepartment">Staff Department:</label>
        <input type="text" id="staffDepartment" name="staffDepartment"><br>

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


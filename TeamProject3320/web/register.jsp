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
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
    <form action="registerCTL" method="post">
    <label for="userType">Select User Type:</label>
    <select id="userType" onchange="showFields()">
        <option value="none">Please select your category</option>
        <option value="sponsor">Sponsor</option>
        <option value="student">Student</option>
        <option value="staff">Staff</option>
    </select>
    
    <input type="hidden" id="userTypeHidden" name="userTypeHidden">

    <div id="sponsorFields" class="hidden">
        <label for="sponsorFName">Sponsor First Name:</label>
        <input type="text" id="sponsorFName" name="sponsorFName"><br>
        <label for="sponsorLName">Sponsor Last Name:</label>
        <input type="text" id="sponsorLName" name="sponsorLName"><br>
        <label for="sponsorCompany">Sponsor Company:</label>
        <input type="text" id="sponsorCompany" name="sponsorCompany"><br>
        <label for="sponsorUName">Sponsor Username:</label>
        <input type="text" id="sponsorUName" name="sponsorUName"><br>
        <label for="sponsorPassword">Sponsor Password:</label>
        <input type="password" id="sponsorPassword" name="sponsorPassword"><br>
        <label for="sponsorPhone">Sponsor Phone Number:</label>
        <input type="tel" id="sponsorPhone" name="sponsorPhone"><br>
        <label for="sponsorEmail">Sponsor Email:</label>
        <input type="email" id="sponsorEmail" name="sponsorEmail"><br>
        <label for="sponsorTitle">Sponsor Title:</label>
        <input type="text" id="sponsorTitle" name="sponsorTitle"><br>
        
    </div>

    <div id="studentFields" class="hidden">
        <label for="studentFName">Student First Name:</label>
        <input type="text" id="studentFName" name="studentFName"><br>
        <label for="studentLName">Student Last Name:</label>
        <input type="text" id="studentLName" name="studentLName"><br>
        <label for="studentUName">Student Username:</label>
        <input type="text" id="studentUName" name="studentUName"><br>
        <label for="studentPassword">Student Password:</label>
        <input type="password" id="studentPassword" name="studentPassword"><br>
        <label for="studentPhone">Student Phone:</label>
        <input type="tel" id="studentPhone" name="studentPhone"><br>
        <label for="studentEmail">Student Email:</label>
        <input type="email" id="studentEmail" name="studentEmail"><br>
        <label for="studentSkills">Student Skills:</label>
        <input type="text" id="studentSkills" name="studentSkills"><br>
        <label for="studentYear">Student Academic Year:</label>
            <select id="studentYear" name="studentYear">
                <option value="Freshman">Freshman</option>
                <option value="Sophomore">Sophomore</option>
                <option value="Junior">Junior</option>
                <option value="Senior">Senior</option>
            </select><br>
        <label for="studentMajor">Student Major:</label>
        <input type="text" id="studentMajor" name="studentMajor"><br>
        <label for="studentMinor">Student Minor:</label>
        <input type="text" id="studentMinor" name="studentMinor"><br>
        <label for="studentSchool">Student School:</label>
        <input type="text" id="studentSchool" name="studentSchool"><br>
        <label for="studentPast">Student Past Experiences:</label>
        <input type="text" id="studentPast" name="studentPast"><br>
    </div>

    <div id="staffFields" class="hidden">
        <label for="staffFName">Staff Name:</label>
        <input type="text" id="staffFName" name="staffFName"><br>
        <label for="staffLName">Staff Last Name:</label>
        <input type="text" id="staffLName" name="staffLName"><br>
        <label for="staffUName">Staff Username:</label>
        <input type="text" id="staffUName" name="staffUName"><br>
        <label for="staffPassword">Staff Password:</label>
        <input type="password" id="staffPassword" name="staffPassword"><br>
        <label for="studentPhone">Staff Phone:</label>
        <input type="tel" id="staffPhone" name="staffPhone"><br>
        <label for="staffEmail">Staff Email:</label>
        <input type="email" id="staffEmail" name="staffEmail"><br>
        <label for="staffDepartment">Staff Department:</label>
        <input type="text" id="staffDepartment" name="staffDepartment"><br>

    </div>
    <button type="submit" id="submitButton" style="display:none;">Submit</button>
    </form>
    
    <script>
        function showFields() {
            var userType = document.getElementById("userType").value;
            document.getElementById("userTypeHidden").value = userType; // Set the value of the hidden input field
            document.getElementById("sponsorFields").style.display = userType === "sponsor" ? "block" : "none";
            document.getElementById("studentFields").style.display = userType === "student" ? "block" : "none";
            document.getElementById("staffFields").style.display = userType === "staff" ? "block" : "none";
            
            //making the submit button if a user type is selected
            document.getElementById("submitButton").style.display = userType ? "inline-block" : "none";
        }
    </script>
</body>
</html>


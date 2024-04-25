<%-- 
    Document   : updateProfile
    Created on : Apr 25, 2024, 12:25:35 PM
    Author     : celso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
    </head>
    <body>
        <h1>Update Profile</h1>
        <form action="updateProfileCTL" method="post">
        <label for="userField">Select Field Change:</label>
            <select id="userField" onchange="showFields()">
                <option value="none">Please select your category</option>
                <option value="fname">First Name</option>
                <option value="lname">Last Name</option>
                <option value="phone">Phone</option>
                <option value="email">Email</option>
                <option value="school">School</option>
                <option value="year">Academic Year</option>
                <option value="major">Major</option>
                <option value="minor">Minor</option>
                <option value="skills">Skills</option>
                <option value="past">Past Experiences</option>
            </select>
    
    <input type="hidden" id="userFieldHidden" name="userFieldHidden">
    
    <div id="firstnameFields" class="hidden">
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname"><br>
    </div>
    <div id="lnameFields" class="hidden">
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname"><br>
    </div>
    <div id="phoneFields" class="hidden">
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone"><br>
    </div>
    <div id="emailFields" class="hidden">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br>
    </div>
    <div id="schoolFields" class="hidden">
        <label for="school">School:</label>
        <input type="text" id="school" name="school"><br>
    </div>
    <div id="yearFields" class="hidden">
        <label for="year">Academic Year:</label>
        <input type="text" id="year" name="year"><br>
    </div>
    <div id="majorFields" class="hidden">
        <label for="major">Major:</label>
        <input type="text" id="major" name="major"><br>
    </div>
    <div id="minorFields" class="hidden">
        <label for="minor">Minor:</label>
        <input type="text" id="minor" name="minor"><br>
    </div>
    <div id="skillsFields" class="hidden">
        <label for="skills">Skills:</label>
        <input type="text" id="skills" name="skills"><br>
    </div>
    <div id="pastFields" class="hidden">
        <label for="past">Past Experiences:</label>
        <input type="text" id="past" name="past"><br>
    </div>
    <button type="submit" id="submitButton" style="display:none;">Submit</button>
    </form>
    
    <script>
        function showFields() {
            var userField = document.getElementById("userField").value;
            document.getElementById("userFieldHidden").value = userField; // Set the value of the hidden input field
            document.getElementById("firstnameFields").style.display = userField === "fname" ? "block" : "none";
            document.getElementById("lnameFields").style.display = userField === "lname" ? "block" : "none";
            document.getElementById("phoneFields").style.display = userField === "phone" ? "block" : "none";
            document.getElementById("emailFields").style.display = userField === "email" ? "block" : "none";
            document.getElementById("schoolFields").style.display = userField === "school" ? "block" : "none";
            document.getElementById("yearFields").style.display = userField === "year" ? "block" : "none";
            document.getElementById("majorFields").style.display = userField === "amjor" ? "block" : "none";
            document.getElementById("minorFields").style.display = userField === "minor" ? "block" : "none";
            document.getElementById("skillsFields").style.display = userField === "skills" ? "block" : "none";
            document.getElementById("pastFields").style.display = userField === "past" ? "block" : "none";
            
            //making the submit button if a user type is selected
            document.getElementById("submitButton").style.display = userField ? "inline-block" : "none";
        }
    </script>
    </body>
</html>

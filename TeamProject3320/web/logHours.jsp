/*
Author: Jordan Ibezim
*/

<!DOCTYPE html>
<html>
<head>
    <title>Student Projects</title>
</head>
<body>
    <h1>Student Projects</h1>
    <ul>
        <% for (Project project : studentProjects) { %>
            <li>
                <strong><%= project.getTitle() %></strong>
                <p>Description: <%= project.getDescription() %></p>
                <p>Logged Hours: <%= project.getLoggedHours() %></p> <!-- Display logged hours -->
                <!-- Add a form to log hours -->
                <form action="logHours" method="post">
                    <input type="hidden" name="projectId" value="<%= project.getId() %>">
                    <input type="number" name="hours" placeholder="Enter hours">
                    <button type="submit">Log Hours</button>
                </form>
            </li>
        <% } %>
    </ul>
</body>
</html>